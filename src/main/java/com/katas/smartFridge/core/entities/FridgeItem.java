package com.katas.smartFridge.core.entities;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FridgeItem {

    private final String barcode;
    private final String name;
    private final LocalDateTime expiryDate;
    private final FridgeItemState state;
    private LocalDateTime timestampOfScan;


    FridgeItem(String barcode, String name, LocalDateTime expiryDate, FridgeItemState state) {
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

    public LocalDateTime getTimestampOfScan() {
        return timestampOfScan;
    }

    public String getSummaryOfItemForDate(LocalDateTime currentTime) {
        final StringBuilder sb = new StringBuilder();
        sb
                .append(computeIfExpiry(currentTime))
                .append(this.name)
                .append(getRemainingDays(currentTime));

        return sb.toString();
    }

    private String computeIfExpiry(LocalDateTime currentTime) {
        int daysToExpiry = (int) currentTime.until(expiryDate, ChronoUnit.DAYS);
        return daysToExpiry < 0 ? "EXPIRED: " : "";
    }

    private String getRemainingDays(LocalDateTime currentTime) {
        int daysToExpiry = (int) currentTime.until(expiryDate, ChronoUnit.DAYS);
        return daysToExpiry > -1 ? ": " + String.valueOf(daysToExpiry) + " days remaining" : "";
    }
}
