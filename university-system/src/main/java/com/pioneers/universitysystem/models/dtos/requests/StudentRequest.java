package com.pioneers.universitysystem.models.dtos.requests;

import java.util.Objects;

public class StudentRequest {
    private final int id;
    private final String name;
    private final double grade;
    private final String email;

    public StudentRequest(int id, String name, double grade, String email) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StudentRequest that)) return false;
        return id == that.id && Double.compare(grade, that.grade) == 0 &&
                Objects.equals(name, that.name) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, grade, email);
    }

    @Override
    public String toString() {
        return "StudentRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gpa=" + grade +
                ", email='" + email + '\'' +
                '}';
    }
}
