package com.katas.smartFridge.core.ports;

import com.katas.smartFridge.core.entities.FridgeItem;

import java.util.Map;

public interface IStorage {

    void add(FridgeItem item);

    FridgeItem remove(String itemId);

    FridgeItem findById(String itemId);

    Map<String, FridgeItem> findByAll();

    void checkIfItemExists(FridgeItem newItem);
}
