package com.pioneers.functionalprogramming.streams;

import com.pioneers.functionalprogramming.utils.Item;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
       /* final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        final int sum = numbers.stream()
                .filter(Main::isEven)
//                .reduce(1, Main::multiply);
        .mapToInt(Main::addOne)
                .sum();


        System.out.println("sum= " + sum); */

        List<Item> cart = List.of(
                new Item("Mouse", 2, 250.0, "Electronics"),
                new Item("Keyboard", 1, 500.0, "Electronics"),
                new Item("Monitor", 1, 3000.0, "Electronics"),
                new Item("Apple", 5, 20.0, "Food"),
                new Item("Bread", 2, 15.0, "Food")
        );


        double priceAfterDiscount = cart.stream()
                .mapToDouble(item -> {
                    double itemTotal = item.price() * item.quantity();
                    return item.price() >= 500 ? applyDiscount(itemTotal) : itemTotal;
                })
                .sum();

        System.out.println("priceAfterDiscount = " + priceAfterDiscount);

        Map<String,Double> categoriesByItems = cart.stream()
                        .collect(Collectors.groupingBy(
                                Item::category,
                                Collectors.summingDouble(item -> item.price() * item.quantity())
                        ));

        System.out.println("categoriesByItems = " + categoriesByItems);


    }

    private static double applyDiscount(double itemTotal) {
        return itemTotal * 0.9;
    }


    public static int addOne(final int num) {
        return num + 1;
    }

    public static int sum(final int num1, final int num2) {
        return num1 + num2;
    }

    public static int multiply(final int num1, final int num2) {
        return num1 * num2;
    }

    private static boolean isEven(final int number) {
        return number % 2 == 0;
    }

    private static boolean isOdd(final int number) {
        return number % 2 != 0;
    }
}
