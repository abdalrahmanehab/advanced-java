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


        Student student1 = new Student("Mostafa", 24, "123");
        Student student2 = new Student("Mostafa", 24, "123");

        System.out.println("student1.hashCode() = " + student1.hashCode());
        System.out.println("student2.hashCode() = " + student2.hashCode());

        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);

        System.out.println("students = " + students);

        String str1 = "Aa";
        String str2 = "BB";

        System.out.println("str1.hashCode() = " + str1.hashCode());
        System.out.println("str2.hashCode() = " + str2.hashCode());

    }

    public static boolean isOdd(final int number) {
        return number % 2 != 0;
    }
}
