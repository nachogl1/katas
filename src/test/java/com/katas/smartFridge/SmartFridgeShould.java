package com.katas.smartFridge;

import com.katas.smartFridge.core.entities.FridgeItem;
import com.katas.smartFridge.core.entities.SmartFridge;
import com.katas.smartFridge.core.ports.IClock;
import com.katas.smartFridge.core.ports.IOutputPrinter;
import com.katas.smartFridge.core.ports.IStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static com.katas.smartFridge.core.entities.FridgeItemBuilder.getFridgeItemBuilder;
import static com.katas.smartFridge.core.entities.FridgeItemState.SEALED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class SmartFridgeShould {

    private IOutputPrinter consoleMock;
    private IStorage storageMock;
    private IClock clockMock;
    private SmartFridge fridge;
    private FridgeItem item;

    @BeforeEach
    void setUp() {
        consoleMock = mock(IOutputPrinter.class);
        storageMock = mock(IStorage.class);
        clockMock = mock(IClock.class);
        fridge = new SmartFridge(consoleMock, storageMock, clockMock);
        item = getFridgeItemBuilder().setBarcode("1").setName("Milk").setExpiryDate(LocalDateTime.of(2021, 10, 20, 21, 00)).setState(SEALED).build();
    }

    @Test
    void addNewItem() {
        fridge.addItem(item);
        verify(storageMock).add(item);
    }

    @Test
    void assignTimestampToItemWhenAdded() {
        LocalDateTime expectedTimestamp = LocalDateTime.now();
        when(clockMock.getCurrentMoment()).thenReturn(expectedTimestamp);

        fridge.addItem(item);


        assertEquals(expectedTimestamp, item.getTimestampOfScan());

    }

    @Test
    void removeItem() {
        fridge.addItem(item);
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

    @ParameterizedTest
    @CsvSource({"1", "2", "3", "4", "21"})
    void showContainedTwoItemsAddedOneDayBeforeExpiring(int daysBeforeExpiry) {
        int dayOfMonth = 5;
        when(clockMock.getCurrentMoment()).thenReturn(LocalDateTime.of(2022, 10, dayOfMonth, 21, 00));
        FridgeItem lettuceItem = getFridgeItemBuilder().setBarcode("2").setName("Lettuce").setExpiryDate(LocalDateTime.of(2022, 10, dayOfMonth + daysBeforeExpiry, 21, 00)).setState(SEALED).build();
        FridgeItem chorizoItem = getFridgeItemBuilder().setBarcode("3").setName("Chorizo").setExpiryDate(LocalDateTime.of(2022, 10, dayOfMonth + daysBeforeExpiry, 21, 00)).setState(SEALED).build();

        Map<String, FridgeItem> items = new HashMap<>() {{
            put(lettuceItem.getBarcode(), lettuceItem);
            put(chorizoItem.getBarcode(), chorizoItem);
        }};

        when(storageMock.findByAll()).thenReturn(items);

        fridge.addItem(lettuceItem);
        fridge.addItem(chorizoItem);
        fridge.showDisplay();

        verify(consoleMock).print(String.format("Lettuce: %1$d days remaining\nChorizo: %1$d days remaining\n", daysBeforeExpiry));
    }

    @ParameterizedTest
    @CsvSource({"1", "2", "3", "4", "10"})
    void showExpiredItemsCorrectly(int daysOverTheExpiryDate) {
        int dayOfMonth = 20;
        when(clockMock.getCurrentMoment()).thenReturn(LocalDateTime.of(2022, 10, dayOfMonth, 21, 00));
        FridgeItem lettuceItem = getFridgeItemBuilder().setBarcode("2").setName("Lettuce").setExpiryDate(LocalDateTime.of(2022, 10, dayOfMonth - daysOverTheExpiryDate, 21, 00)).setState(SEALED).build();
        FridgeItem chorizoItem = getFridgeItemBuilder().setBarcode("3").setName("Chorizo").setExpiryDate(LocalDateTime.of(2022, 10, dayOfMonth - daysOverTheExpiryDate, 21, 00)).setState(SEALED).build();

        Map<String, FridgeItem> items = new HashMap<>() {{
            put(lettuceItem.getBarcode(), lettuceItem);
            put(chorizoItem.getBarcode(), chorizoItem);
        }};

        when(storageMock.findByAll()).thenReturn(items);

        fridge.addItem(lettuceItem);
        fridge.addItem(chorizoItem);
        fridge.showDisplay();

        verify(consoleMock).print("EXPIRED: Lettuce\nEXPIRED: Chorizo\n");
    }


}

