package com.pioneers.datastructures.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ArrayListMain {
    public static void main(String[] args) {

        List<String> students = new ArrayList<>();
        students.add("Somaya");
        students.add("Basma");
        students.add("Asmaa");
        students.add("Atyat");

        // Default capacity is 10
        List<String> names = new ArrayList<>();
        names.add("Abdelaziz");
        names.add("Mostafa");
        names.add("Kareem");
        names.add("Ali");
        names.add("Elsayed");

        System.out.println(names);

        names.set(3, "Aly");
        System.out.println(names);

        names.add(2, "Ezzat");
        System.out.println(names);

        names.addAll(3, students);
        System.out.println(names);

        System.out.println("names.size() = " + names.size());

        names.add("Mahmoud");
        System.out.println(names);

        names.add("Ibrahim");
        System.out.println(names);
        System.out.println("names.size() = " + names.size());

        names.remove("Ibrahim");
        System.out.println(names);

        /*names.clear();
        System.out.println(names);
        System.out.println("names.size() = " + names.size());*/

        List<String> archivedStudents = List.of("Somaya", "Basma", "Atyat");

        names.removeAll(archivedStudents);
        System.out.println(names);

        System.out.println("names.get(2) = " + names.get(2));

        System.out.println("names.isEmpty() = " + names.isEmpty());
        System.out.println("names.contains(\"abdelaziz\") = " + names.contains("Abdelaziz"));

        List<String> searchStudents = List.of("Abdelaziz", "Mostafa", "Ezzat");
        System.out.println("names.containsAll(searchStudents) = " + names.containsAll(searchStudents));

        System.out.println("names.reversed() = " + names.reversed());

        System.out.println(names);

        System.out.println("--------------------------------------------------------------");

        // Iterate by indexed-for
        for (int i = 0; i < names.size(); i++) {
            System.out.println("names.get(i) = " + names.get(i));
        }

        System.out.println("----------------------------------");

        // Iteration by enhanced-for
        for (final String name : names) {
            System.out.printf("name = %s\n", name);
        }

        System.out.println("-----------------------------------");

        // Iteration by Iterator
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }

        System.out.println("-----------------------------------");

        // Iteration by forEach() with Lambda Expression
        /*Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String name) {
                if (name.startsWith("A")) {
                    System.out.println(name);
                }
            }
        };*/

        Consumer<String> consumer = name -> {
            if (name.startsWith("A")) {
                System.out.println(name);
            }
        };

        names.forEach(consumer);

        // Iteration by forEach() with Lambda Expression
        names.forEach(name -> printNameStartsWithA(name));

        // Iteration by forEach() with Method Reference
        names.forEach(ArrayListMain::printNameStartsWithA);

        System.out.println("=================================================");
        // Iteration by forEach() with streams
        names.stream().forEach(ArrayListMain::printNameStartsWithA);

        System.out.println("=================================================");

        names.forEach(System.out::println);

        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 10, 3, 9, 4, 5));
        numbers.remove(Integer.valueOf(4));
        System.out.println(numbers);
    }

    public static void printNameStartsWithA(String name) {
        if (name.startsWith("A")) {
            System.out.println(name);
        }
    }
}
