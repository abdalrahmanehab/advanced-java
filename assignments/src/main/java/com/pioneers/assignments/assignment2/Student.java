package com.pioneers.assignments.assignment2;

import java.util.HashSet;
import java.util.Set;

public class Student {
    final private Integer id;
    final private String name;
    private Set<Course> studentCourses = new HashSet<>();

    public Student(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void enrollCourse (Course course) {
        studentCourses.add(course);
    }

    public int getCoursesNumber (){
        return studentCourses.size();
    }

    public Set<Course> getEnrolledCourses (){
        return studentCourses;
    }

    @Override
    public String toString() {
        return name;
    }
}
