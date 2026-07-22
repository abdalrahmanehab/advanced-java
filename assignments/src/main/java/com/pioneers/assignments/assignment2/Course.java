package com.pioneers.assignments.assignment2;

import java.util.Objects;

public class Course {
    final private int id;
    final private String title;

    public Course(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Course course)) return false;
        return id == course.id && Objects.equals(title, course.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return title + " ";
    }


}
