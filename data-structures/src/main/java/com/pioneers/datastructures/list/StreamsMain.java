package com.pioneers.datastructures.list;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StreamsMain {
    public static void main(String[] args) {

        final List<Integer> numbers = new LinkedList<>(List.of(1, 2, 10, 3, 9, 4, 5, 4, 4, 8, 2, 6));

        try {
            final int firstElement = numbers.stream()
                    .distinct()
                    .filter(StreamsMain::isEven)
                    .filter(StreamsMain::isGreaterThree)
                    .sorted(Comparator.reverseOrder())
                    .filter(StreamsMain::isGreaterTwenty)
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException("The list is empty"));

            System.out.println("filteredList = " + firstElement);

        } catch (final NotFoundException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    public static boolean isEven(final int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(final int number) {
        return number % 2 != 0;
    }

    public static boolean isGreaterThree(final int number) {
        return number > 3;
    }

    public static boolean isGreaterTwenty(final int number) {
        return number > 20;
    }
}
