package com.pioneers.universitysystem.repositories;

import com.pioneers.universitysystem.models.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class StudentRepository {
    List<Student> list = new ArrayList<>();

    public Student save(Student student){
        list.add(student);
        return student;
    }

    public Optional<Student> findById (int id) {
        return list.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    public boolean deleteStudent (int id) {
        return list.removeIf(student -> student.getId() == id);
    }

    public void saveAll(List<Student> newStudents) {
        list.addAll(newStudents);
    }

    public List<Student> getAllStudents() {
        return list;
    }

}
