package com.pioneers.datastructures.set;

import com.pioneers.datastructures.list.StreamsMain;

import java.util.*;

public class HashSetMain {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(16);
        numbers.add(2);
        numbers.add(20);
        numbers.add(16);
        numbers.add(20);
        numbers.add(82);
        numbers.add(34);
        numbers.add(null);

        System.out.println("numbers = " + numbers);

        System.out.println("numbers.isEmpty() = " + numbers.isEmpty());
        System.out.println("numbers.size() = " + numbers.size());
        numbers.remove(null);
        System.out.println("numbers = " + numbers);

        System.out.println("numbers.contains(16) = " + numbers.contains(16));
        numbers.stream()
                .filter(StreamsMain::isOdd)
                .forEach(System.out::println);

        System.out.println("-----------------------");


    }

    public static boolean isOdd(final int number) {
        return number % 2 != 0;
    }
}
