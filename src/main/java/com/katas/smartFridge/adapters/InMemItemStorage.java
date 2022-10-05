package com.katas.smartFridge.adapters;

import com.katas.smartFridge.core.entities.FridgeItem;
import com.katas.smartFridge.core.entities.RepeatedItemBarcodeFoundException;
import com.katas.smartFridge.core.ports.IStorage;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class InMemItemStorage implements IStorage {

    private Map<String, FridgeItem> fridgeItems = new HashMap<>();

    @Override
    public void add(FridgeItem item) {
        this.fridgeItems.put(item.getBarcode(), item);
    }

    @Override
    public FridgeItem remove(String itemId) {
        return this.fridgeItems.remove(itemId);
    }

    @Override
    public FridgeItem findById(String itemId) {
        return Optional.ofNullable(this.fridgeItems.get(itemId)).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    public void checkIfItemExists(FridgeItem newItem) {
        if (this.fridgeItems.get(newItem.getBarcode()) != null)
            throw new RepeatedItemBarcodeFoundException(newItem.getBarcode());
    }

    public Map<String, FridgeItem> findByAll() {
        return fridgeItems;
    }
}
