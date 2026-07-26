package com.pioneers.datastructures.task;

import java.util.LinkedList;
import java.util.List;

public class LibraryLoanSystem {

    public static void main(String[] args) {
        final LibraryManagement libraryManagement = new LibraryManagement(defaultBooks());

        libraryManagement.printAllBooksInfo();

        System.out.println("111----------------------------");

        libraryManagement.loanBookById(3);
        libraryManagement.loanBookById(2);

        libraryManagement.printAllLoanedBooksInfo();
        System.out.println("222---------------------------");
        libraryManagement.printAllNonLoanedBooksInfo();
        System.out.println("333---------------------------");

        libraryManagement.retrieveBookById(3);

        libraryManagement.printAllNonLoanedBooksInfo();

        System.out.println("444---------------------------");

        libraryManagement.printAllLoanedBooksInfo();
    }

    private static List<Book> defaultBooks() {
        final List<Book> books = new LinkedList<>();
        books.add(new Book(1,"Adventure Book", ""));
        books.add(new Book(2,"Comedy Book", ""));
        books.add(new Book(3,"Java Book", ""));
        books.add(new Book(4,"Novel Book", ""));
        books.add(new Book(5,"Crime Book", ""));

        return books;
    }
}
