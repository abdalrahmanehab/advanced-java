package com.pioneers.datastructures.set;

import java.util.HashSet;
import java.util.Set;

public class LinkedHashSet {
    public static void main(String[] args) {
        TheInteger integer1 = TheInteger.valueOf(30);
        TheInteger integer2 = TheInteger.valueOf(30);

        if (integer1.equals(integer2)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        Student student1 = new Student("Abdelaziz", 12, "123");
        Student student2 = new Student("Abdelaziz", 12, "321");

        System.out.println("student1.getClass() = " + student1.getClass());

        if (student1.equals(student2)) {
            System.out.println("students are equals");
        } else {
            System.out.println("students are not equals");
        }

        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        System.out.println(students);

        System.out.println("student1.hashCode() = " + student1.hashCode());
        System.out.println("student2.hashCode() = " + student2.hashCode());

        TheInteger num1 = TheInteger.valueOf(30);
        TheInteger num2 = TheInteger.valueOf(30);

        System.out.println("num1.hashCode() = " + num1.hashCode());
        System.out.println("num2.hashCode() = " + num2.hashCode());

    }
}
