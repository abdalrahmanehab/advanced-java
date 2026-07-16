package com.pioneers.assignments.assignment1;

import java.util.*;

class Book {
    private final Integer id;
    private final String name;

    public Book(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class LibrarySystemMain {

    public static void printBooks(Map<Integer, Book> booksInLibrary) {
        for (Book book : booksInLibrary.values()) {
            System.out.println(book.getId() + " - " + book.getName());
        }
    }

    public static void printLoanedBooks(LinkedHashSet<Integer> loanedBooks,Map<Integer, Book> booksInLibrary ) {
        for(int id : loanedBooks){
            System.out.println(id + " - " + getBookName(booksInLibrary,id));
        }
    }

    public static String getBookName (Map<Integer, Book> booksInLibrary ,int id){
        return booksInLibrary.get(id).getName();
    }



    public static LinkedHashSet<Integer> loanBook(final LinkedHashSet<Integer> loanedBooks, int id) {
        LinkedHashSet<Integer> copiedLoanedBooks = new LinkedHashSet<>(loanedBooks);
        boolean found = copiedLoanedBooks.contains(id);
        if(found) {
            System.out.println("error: Book with ID " + id + " is already loaned out!");
            return copiedLoanedBooks;
        }
        copiedLoanedBooks.add(id);
        return copiedLoanedBooks;

    }

    public static LinkedHashSet<Integer> returnBook(LinkedHashSet<Integer> loanedBooks, int id) {
        LinkedHashSet<Integer> copiedLoanedBooks = new LinkedHashSet<>(loanedBooks);
        boolean found = copiedLoanedBooks.contains(id);

        if(!found) {
            System.out.println("erorr: this book is not currently loaned out!");
            return copiedLoanedBooks;
        }

        copiedLoanedBooks.remove(id);
        return copiedLoanedBooks;
    }

    public static int getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static boolean isBookExist(Map<Integer, Book> booksInLibrary, int id) {
        return booksInLibrary.containsKey(id);
    }

    public static void main(String[] args) {

        Map<Integer, Book> booksInLibrary = new LinkedHashMap<>(Map.of(
                1, new Book(1, "It Starts with Us"),
                2, new Book(2, "It Ends with Us"),
                3, new Book(3, "Verity"),
                4, new Book(4, "Ugly Love"),
                5, new Book(5, "Abdalrahman's Diary")
        ));

        printBooks(booksInLibrary);
        LinkedHashSet<Integer> loanedBooks = new LinkedHashSet<>();


        System.out.println("how many books you want to loan (up to 3 only) ? ");
        int num = getInput();
        for(int i = 0; i < num ;i++) {
            System.out.print("Enter Book ID: ");
            int id = getInput();


            if (!isBookExist(booksInLibrary, id)) {
                System.out.println("Book not found.");
                continue;
            }

            loanedBooks = loanBook(loanedBooks, id);

        }

        printLoanedBooks(loanedBooks,booksInLibrary);



    }
}