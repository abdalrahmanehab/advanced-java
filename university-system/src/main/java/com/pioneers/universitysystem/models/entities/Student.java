package com.pioneers.universitysystem.models.entities;

public class Student {
    private int id;
    private String name;
    private double grade;
    private boolean isPassed;
    private String email;

    public Student() {
    }

    public Student(int id, String name, double gpa, String email) {
        this.id = id;
        this.name = name;
        this.grade = gpa;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gpa=" + grade +
                ", isPassed=" + isPassed +
                ", email='" + email + '\'' +
                '}';
    }
}