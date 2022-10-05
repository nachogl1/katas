package com.katas.smartFridge.core.entities;

import java.time.LocalDateTime;

public class FridgeItem {

    private final String barcode;
    private final String name;
    private final String expiryDate;
    private final FridgeItemState state;
    private LocalDateTime timestampOfScan;


    FridgeItem(String barcode, String name, String expiryDate, FridgeItemState state) {
        this.barcode = barcode;
        this.name = name;
        this.expiryDate = expiryDate;
        this.state = state;
    }

    public void setTimestampOfScanNow(LocalDateTime timestamp) {
        this.timestampOfScan = timestamp;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public FridgeItemState getState() {
        return state;
    }

    public LocalDateTime getTimestampOfScan() {
        return timestampOfScan;
    }


}
