package com.katas.smartFridge.core.entities;

import java.time.LocalDateTime;
import java.util.Map;

public class FridgeItemFormatter {
    public String formatItemsToString(Map<String, FridgeItem> items, LocalDateTime currentDate) {
        StringBuffer summary = new StringBuffer();

        items.forEach((k, v) -> {
            summary
                    .append(v.getSummaryOfItemForDate(currentDate))
                    .append("\n");
        });
        return summary.toString();
    }
}
