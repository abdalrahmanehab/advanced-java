package com.pioneers.datastructures.set;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(13);
        set.add(34);
        set.add(2);
        set.add(34);
        set.add(19);

        System.out.println("set = " + set);
        set.retainAll(List.of(2, 34, 19));
        System.out.println("set = " + set);
    }
}
