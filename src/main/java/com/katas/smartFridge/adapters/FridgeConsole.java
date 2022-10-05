package com.katas.smartFridge.adapters;

import com.katas.smartFridge.core.ports.IOutputPrinter;

public class FridgeConsole implements IOutputPrinter {
    @Override
    public void print(String messageToPrint) {
        System.out.println(messageToPrint);
    }
}
