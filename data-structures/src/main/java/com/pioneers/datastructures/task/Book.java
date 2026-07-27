package com.pioneers.datastructures.task;

import java.util.Objects;

public class Book {
    private final int id;
    private final String name;
    private final String description;
    private boolean isLoaned;

    public Book(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String publicBookInfo() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void loanBook() throws BookException {
        if (isLoaned()) {
            throw new BookException("Book with id: [] " + id + " already loaned");
        }

        this.isLoaned = true;
    }

    public void retrieveBook() {
        if (!isLoaned()) {
            throw new BookException("Book with id: [] not loaned");
        }

        this.isLoaned = false;
    }

    public boolean isIdMatched(final int id) {
        return this.id == id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isLoaned() {
        return isLoaned;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id
                && isLoaned == book.isLoaned
                && Objects.equals(name, book.name)
                && Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, isLoaned);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isLoaned=" + isLoaned +
                '}';
    }
}
