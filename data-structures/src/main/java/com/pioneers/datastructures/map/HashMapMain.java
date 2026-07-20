package com.pioneers.datastructures.map;

import com.pioneers.datastructures.set.Student;

import java.util.*;

public class HashMapMain {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Abdelaziz");
        map.put(2, "Mostafa");
        map.put(3, "Kareem");
        map.put(null, "Ahmed");
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

        Map<Integer, String> map1 = new Hashtable();
        map1.put(1, "Abdelaziz");
        map1.put(1, "Mostafa");

        System.out.println(map1);

        Set<Integer> integers = new HashSet<>(List.of(2, 10, 7, 13, 20, 11, 4, 2));
        Collection<Integer> sortedSet = integers.stream()
                .sorted()
                .toList();

        Student student1 = new Student("Mostafa", 24, "123");
        Student student2 = new Student("Kareem", 29, "321");
        Student student3 = new Student("Kareem", 29, "321");
        Student student4 = new Student("Ahmed", 30, "321");

        Map<Student, String> map2 = new HashMap<>();
        map2.put(student1, "abc");
        map2.put(student2, "def");
        map2.put(student3, "ghi");

        System.out.println("map2 = " + map2);

        try {
            final String student1Value = get(student1, map2);
            System.out.println("student1Value = " + student1Value);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Map<String, Student> map3 = new HashMap<>();
        map3.put("1234567890", student1);
        map3.put("1234567891", student2);

        Map<String, Student> map4 = new HashMap<>(map3);

        System.out.println(map4);

        for (final Map.Entry<String, Student> entry : map4.entrySet()) {
            System.out.println("entry.getKey() = " + entry.getKey());
            System.out.println("entry.getValue() = " + entry.getValue());
        }

        System.out.println("-----------------------------------------");

        HashMapMain hashMapMain = new HashMapMain();

        map4.entrySet().forEach(hashMapMain::printMapElement);

        System.out.println("-----------------------------------------");

        map4.forEach(HashMapMain::printMapElement);
    }

    public void printMapElement(final Map.Entry<String, Student> entry) {
        System.out.println("entry.getKey() = " + entry.getKey());
        System.out.println("entry.getValue() = " + entry.getValue());
    }

    public static void printMapElement(final String key, final Student value) {
        System.out.println("key = " + key);
        System.out.println("value = " + value);
    }

    public static synchronized <K, V> V get(final K key, final Map<K, V> map) {
        return Optional.ofNullable(map.get(key))
                .orElseThrow(() -> new IllegalArgumentException("key not found"));
    }
}
