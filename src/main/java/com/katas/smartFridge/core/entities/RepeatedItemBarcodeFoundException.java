package com.katas.smartFridge.core.entities;

public class RepeatedItemBarcodeFoundException extends RuntimeException {
    public RepeatedItemBarcodeFoundException(String problematicBarcode) {
        super(buildErrorMessage(problematicBarcode));
    }

    private static String buildErrorMessage(String problematicBarcode) {
        return String.format("Barcode %s is already registered in Smart Fridge", problematicBarcode);
    }
}
