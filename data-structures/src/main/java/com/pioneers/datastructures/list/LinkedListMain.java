package com.pioneers.datastructures.list;

import java.util.*;
import java.util.function.Consumer;

public class LinkedListMain {

    private static String theName = "Kareem";

    public static void main(String[] args) {


        Integer num = null;
        Optional<Integer>  op  = Optional.ofNullable(num);

        Optional.ofNullable(num)
                .ifPresent(n -> System.out.println(n));

        Optional.ofNullable(num)
                .ifPresent(System.out::println);

        final List<Integer> ls = new ArrayList<>(Arrays.asList(23,56,34,12,53,15,3,7));
        final List<Integer> sortedList1 = sorted(ls);
        System.out.println(sortedList1);

        String name1 = Optional.of("Abdo")
                .orElse(getDefaultName());

        Optional.of(null)
                .orElse(getDefaultName());

        Optional<String> op1 = Optional.ofNullable(null);
        String s = op1.orElse("Default");
        System.out.println(s);


        List<String> students = new LinkedList<>();
        students.add("Somaya");
        students.add("Basma");
        students.add("Asmaa");
        students.add("Atyat");

        // Default capacity is 10
        List<String> names = new LinkedList<>();
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
        names.forEach(LinkedListMain::printNameStartsWithA);

        System.out.println("=================================================");
        // Iteration by forEach() with streams
        names.stream().forEach(LinkedListMain::printNameStartsWithA);

        System.out.println("=================================================");

        names.forEach(System.out::println);

        final List<Integer> numbers = new LinkedList<>(List.of(1, 2, 10, 3, 9, 4, 5, 4, 4, 8, 2, 6));
//        numbers.remove(Integer.valueOf(4));

        final List<Integer> distinctedList = distinct(numbers);

        System.out.println("distinctedList = " + distinctedList);

        final List<Integer> evenElements = retrieveEvenInList(distinctedList);
        System.out.println("evenElements = " + evenElements);

        final List<Integer> oddElements = retrieveOddInList(distinctedList);
        System.out.println("oddElements = " + oddElements);

        final List<Integer> elementsGreaterThree = retrieveElementsGreaterThree(evenElements);
        System.out.println("elementsGreaterThree = " + elementsGreaterThree);

        final List<Integer> sortedList = sorted(elementsGreaterThree);
        System.out.println("sortedList = " + sortedList);

        final List<Integer> list = new ArrayList<>();

        findFirst(sortedList)
                .ifPresent(LinkedListMain::printElement);

        final int firstNumber = findFirst(list)
                .orElse(0);
        System.out.println("firstNumber = " + firstNumber);

        final int theFirstNumber = findFirst(sortedList)
                .orElseThrow(() -> new NotFoundException("The list is empty, no first number found"));

        System.out.println("theFirstNumber = " + theFirstNumber);

//        Integer number = 4;
//        Optional.ofNullable(number)
//                .ifPresent(LinkedListMain::printElement);

        Integer number = null;

        Optional<Integer> firstElement = Optional.empty();
        Optional<Integer> theFirstElement = Optional.of(8);
        Optional<Integer> theFirstElement2 = Optional.ofNullable(number);

        theFirstElement2
                .ifPresent(LinkedListMain::printElement);

        if (theFirstElement2.isEmpty()) {
            printErrorInfo();
        }

        theFirstElement2
                .ifPresentOrElse(LinkedListMain::printSucessInfo, LinkedListMain::printErrorInfo);

        System.out.println("----------------------------------------");

        final int firstValueOrDefaultValue = findFirst(list)
                .orElseGet(() -> {
                    System.err.println("theFirstElement2 is empty");
                    return 0;
                });

        System.out.println("firstValueOrDefaultValue = " + firstValueOrDefaultValue);

        final int first = findFirst(sortedList)
                .orElseThrow(() -> new NotFoundException("The list is empty, no first number found"));

        System.out.println("first = " + first);
        String message;
        if (theFirstElement2.isPresent()) {
            System.out.println("theFirstElement2.get() = " + theFirstElement2.get());
        }

        System.out.println("sortedList = " + sortedList);

        final int summation = sum(sortedList);
        System.out.println("summation = " + summation);

        final int average = average(sortedList);
        System.out.println("average = " + average);
    }


    public static int average(final List<Integer> numbers) {
        final int length = numbers.size();

        int sum = 0;
        for (final Integer number : numbers) {
            sum += number;
        }
        return sum / length;
    }

    public static int sum(final List<Integer> numbers) {
        int sum = 0;
        for (final Integer number : numbers) {
            sum += number;
        }

        return sum;
    }

    public static void printSucessInfo(final int number) {
        System.out.println("I am in the first parameter");
        System.out.println("element = " + number);
    }

    public static void printErrorInfo() {
        System.err.println("I am in the second parameter");
        System.err.println("theFirstElement2 is empty");
        System.err.println("number is null");
    }

    public static void printElement(final int element) {
        System.out.println("element = " + element);
    }

    public static Optional<Integer> findFirst(final List<Integer> list) {

        final Optional<List<Integer>> optionalList = Optional.ofNullable(list);

        if (optionalList.isEmpty() || optionalList.get().isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(optionalList.get().getFirst());
    }

    public static int findFirstBadPractise(final List<Integer> list) throws NoSuchElementException {
        if (list == null) {
            throw new NotFoundException("The list is empty, no first number found");
        }

        if (list.isEmpty()) {
            throw new NoSuchElementException("The list is empty, no first number found");
        }

        return list.get(0);
    }

    // Goooooooood Practice
    public static List<Integer> sorted(final List<Integer> list) {
        final List<Integer> redandantList = new ArrayList<>(list);
        redandantList.sort(Integer::compareTo);

        return redandantList;
    }

    // Baaaaaaaaaaaad Practice
    public static void sortedWithMutationReference(final List<Integer> list) {
        //        elementsGreaterThree.sort((element1, elemet2) -> elemet2.compareTo(element1));
        list.sort(Integer::compareTo);
    }

    public static List<Integer> retrieveElementsGreaterThree(final List<Integer> list) {
        final List<Integer> result = new LinkedList<>();

        for (final Integer integer : list) {
            if (integer > 3) {
                result.add(integer);
            }
        }

        return result;
    }

    public static List<Integer> retrieveOddInList(final List<Integer> numbers) {
        final List<Integer> oddList = new LinkedList<>();

        for (final Integer number : numbers) {
            if (isOdd(number)) {
                oddList.add(number);
            }
        }

        return oddList;
    }

    public static List<Integer> retrieveEvenInList(final List<Integer> numbers) {
        final List<Integer> evenList = new LinkedList<>();

        for (final Integer number : numbers) {
            if (isEven(number)) {
                evenList.add(number);
            }
        }

        return evenList;
    }

    private static boolean isOdd(final Integer number) {
        return number % 2 != 0;
    }

    private static boolean isEven(final Integer number) {
        return number % 2 == 0;
    }

    public static List<Integer> distinct(final List<Integer> numbers) {
        final List<Integer> distinct = new LinkedList<>();

        for (final Integer number : numbers) {
            if (!distinct.contains(number)) {
                distinct.add(number);
            }
        }

        return distinct;
    }

    public static void printNameStartsWithA(String name) {
        if (name.startsWith("A")) {
            System.out.println(name);
        }
    }


    static String getDefaultName(){
        System.out.println("runnnig ...");
        return "deafult";
    }


}
