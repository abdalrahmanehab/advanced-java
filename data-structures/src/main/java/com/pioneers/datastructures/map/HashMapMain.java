package com.pioneers.datastructures.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Abdelaziz");
        map.put(2, "Mostafa");
        map.put(3, "Kareem");
        System.out.println(map);

        map.put(2, "Omar");

        System.out.println(map);

        map.putIfAbsent(4, "Ali");
        System.out.println(map);

        map.putIfAbsent(4, "Mostafa");
        System.out.println(map);

        System.out.println("map.get(4) = " + map.get(4));

        map.remove(4);
        System.out.println(map);

        System.out.println("map.size() = " + map.size());

        map.keySet().forEach(System.out::println);
        System.out.println("--------------------");
        map.values().forEach(System.out::println);
        map.entrySet().forEach(entry -> {
            System.out.println("entry.getKey() = " + entry.getKey());
            System.out.println("entry.getValue() = " + entry.getValue());
            System.out.println("----------------------");
        });

        System.out.println("map.containsKey(2) = " + map.containsKey(2));
    }
}
