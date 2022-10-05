package com.katas.smartFridge;

import com.katas.smartFridge.core.entities.FridgeItem;
import com.katas.smartFridge.core.entities.SmartFridge;
import com.katas.smartFridge.core.ports.IClock;
import com.katas.smartFridge.core.ports.IOutputPrinter;
import com.katas.smartFridge.core.ports.IStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import static com.katas.smartFridge.core.entities.FridgeItemBuilder.getFridgeItemBuilder;
import static com.katas.smartFridge.core.entities.FridgeItemState.SEALED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class SmartFridgeShould {

    private IOutputPrinter printerMock;
    private IStorage storageMock;
    private IClock clockMock;
    private SmartFridge fridge;
    private FridgeItem item;

    @BeforeEach
    void setUp() {
        printerMock = mock(IOutputPrinter.class);
        storageMock = mock(IStorage.class);
        clockMock = mock(IClock.class);
        fridge = new SmartFridge(printerMock, storageMock, clockMock);
        item = getFridgeItemBuilder().setBarcode("1").setName("Milk").setExpiryDate("20/10/2021").setState(SEALED).build();
    }

    @Test
    void addNewItem() {
        fridge.scanAddedItem(item);
        verify(storageMock).add(item);
    }

    @Test
    void assignTimestampToItemWhenAdded() {
        LocalDateTime expectedTimestamp = LocalDateTime.now();
        when(clockMock.getCurrentMoment()).thenReturn(expectedTimestamp);

        fridge.scanAddedItem(item);


        assertEquals(expectedTimestamp, item.getTimestampOfScan());

    }

    @Test
    void removeItem() {
        fridge.scanAddedItem(item);
        when(storageMock.remove(item.getBarcode())).thenReturn(item);

        fridge.scanRemovedItem(item.getBarcode());

        verify(storageMock).remove(item.getBarcode());
    }

    @Test
    void throwNoSuchElementExceptionIfTryToRemoveSomethingThatDoesNotExist() {

        when(storageMock.remove(item.getBarcode())).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> {
            fridge.scanRemovedItem(item.getBarcode());
        });

    }
}

