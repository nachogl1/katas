package com.katas.textProcessor;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MapUtils {
    static <K, V extends Comparable<V>> Map<K, V> sortEntryByDescendingValue(final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare = map.get(k2).compareTo(map.get(k1));
                if (compare == 0) return 1;
                else return compare;
            }
        };
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

}
