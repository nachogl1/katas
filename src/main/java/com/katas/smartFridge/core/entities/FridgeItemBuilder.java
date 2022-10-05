package com.katas.smartFridge.core.entities;

import java.time.LocalDateTime;

public class FridgeItemBuilder {

    private static FridgeItemBuilder instance;

    private String barcode;
    private String name;
    private LocalDateTime expiryDate;
    private FridgeItemState state;

    private FridgeItemBuilder() {
    }

    public static FridgeItemBuilder getFridgeItemBuilder() {
        if (instance == null) {
            instance = new FridgeItemBuilder();
        }

        return instance;
    }

    public FridgeItemBuilder setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public FridgeItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public FridgeItemBuilder setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public FridgeItemBuilder setState(FridgeItemState state) {
        this.state = state;
        return this;
    }

    public FridgeItem build() {
        return new FridgeItem(this.barcode, this.name, this.expiryDate, this.state);
    }


}
