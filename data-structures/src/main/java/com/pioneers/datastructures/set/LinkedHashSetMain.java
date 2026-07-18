package com.pioneers.datastructures.set;

import java.util.*;

public class LinkedHashSetMain {
    public static void main(String[] args) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(2);
        set.add(13);
        set.add(34);
        set.add(null);
        set.add(2);
        set.add(34);
        set.add(19);

        System.out.println(set);
        System.out.println("set.contains(13) = " + set.contains(13));
        System.out.println("set.contains(34) = " + set.contains(340));
        System.out.println("set.containsAll(List.of(13, 34, 19)) = " + set.containsAll(List.of(13, 34, 19)));
        set.remove(19);
        System.out.println(set);
        System.out.println("set.getFirst() = " + set.getFirst());
        System.out.println("set.getLast() = " + set.getLast());
    }


    public static void printFirstElement(Collection<Integer> list) {
        System.out.println("list.getFirst() = " + list.stream().findFirst());
    }
}
