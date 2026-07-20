package com.pioneers.datastructures.map;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapMain {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(1, "ONE");
        map.put(2, "TWO");
        map.put(20, "TWENTY");
        map.put(3, "THREE");
        map.put(6, "SIX");
        map.put(4, "FOUR");
        map.put(5, "FIVE");
        map.put(6, null);

        System.out.println("map = " + map);
    }
}
