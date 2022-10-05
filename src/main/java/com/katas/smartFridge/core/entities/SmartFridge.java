package com.katas.smartFridge.core.entities;

import com.katas.smartFridge.core.ports.IClock;
import com.katas.smartFridge.core.ports.IOutputPrinter;
import com.katas.smartFridge.core.ports.IStorage;

import java.util.NoSuchElementException;

public class SmartFridge {

    private IOutputPrinter printer;
    private IClock clockDevice;
    private IStorage storage;
    private FridgeItemFormatter formatter = new FridgeItemFormatter();

    public SmartFridge(IOutputPrinter printer, IStorage storage, IClock clockDevice) {
        this.printer = printer;
        this.storage = storage;
        this.clockDevice = clockDevice;
    }

    public void signalFridgeDoorOpened() {
        throw new UnsupportedOperationException();
    }

    public void signalFridgeDoorClosed() {
        throw new UnsupportedOperationException();
    }

    public void addItem(FridgeItem newItem) {
        this.storage.checkIfItemExists(newItem);
        assignTimestampToItem(newItem);
        this.storage.add(newItem);
    }

    public void scanRemovedItem(String idOfItemToBeRemoved) {
        if (this.storage.remove(idOfItemToBeRemoved) == null)
            throw new NoSuchElementException();
    }

    public void showDisplay() {
        String message = this.formatter.formatItemsToString(this.storage.findByAll(), clockDevice.getCurrentMoment());
        this.printer.print(message);
    }


    private void assignTimestampToItem(FridgeItem newItem) {
        newItem.setTimestampOfScanNow(clockDevice.getCurrentMoment());
    }
}
