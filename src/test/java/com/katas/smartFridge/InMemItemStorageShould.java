package com.katas.smartFridge;

import com.katas.smartFridge.adapters.InMemItemStorage;
import com.katas.smartFridge.core.entities.FridgeItem;
import com.katas.smartFridge.core.entities.RepeatedItemBarcodeFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.katas.smartFridge.core.entities.FridgeItemBuilder.getFridgeItemBuilder;
import static com.katas.smartFridge.core.entities.FridgeItemState.SEALED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InMemItemStorageShould {

    private InMemItemStorage storage;
    private FridgeItem item;

    @BeforeEach
    void setUp() {
        storage = new InMemItemStorage();
        item = getFridgeItemBuilder().setBarcode("1").setName("Milk").setExpiryDate("20/10/2021").setState(SEALED).build();
    }

    @Test
    void addNewItem() {
        storage.add(item);

        Map<String, FridgeItem> items = storage.findByAll();

        assertEquals(1, items.size());
    }

    @Test
    void throwExceptionIfSameBarcodeIsAdded() {
        storage.add(item);

        assertThrows(RepeatedItemBarcodeFoundException.class, () -> {
            storage.checkIfItemExists(item);
        });

    }

    @Test
    void removeItem() {
        storage.add(item);

        storage.remove(item.getBarcode());
        Map<String, FridgeItem> items = storage.findByAll();

        assertEquals(0, items.size());
    }


}
