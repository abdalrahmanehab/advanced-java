package com.pioneers.datastructures.task;

import java.util.List;

public class LibraryManagement {

    private final List<Book> books;

    // Loosely coupled
    public LibraryManagement(List<Book> books) {
        this.books = books;
    }

    public void printAllBooksInfo() {
        books.forEach(LibraryManagement::printBookInfo);
    }

    public void printAllLoanedBooksInfo() {
        books.stream()
                .filter(Book::isLoaned)
                .forEach(LibraryManagement::printBookInfo);
    }

    public void printAllNonLoanedBooksInfo() {
        books.stream()
                .filter(book -> !book.isLoaned())
                .forEach(LibraryManagement::printBookInfo);
    }

    private static void printBookInfo(final Book book) {
        System.out.println(book.publicBookInfo());
    }

    public void loanBookById(final int id) throws BookException {
        final Book foundBook = findBookById(id);

        foundBook.loanBook();
    }

    public void retrieveBookById(final int id) {
        final Book foundBook = findBookById(id);

        foundBook.retrieveBook();
    }

    private Book findBookById(final int id) {
        return books.stream()
                .filter(book -> book.isIdMatched(id))
                .findFirst()
                .orElseThrow(() -> new BookException("Book with id " + id + " not found"));
    }
}
