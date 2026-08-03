package com.pioneers.rest.repositories;

import com.pioneers.rest.errors.exceptions.RegisterException;
import com.pioneers.rest.models.dtos.requests.StudentRegister;
import com.pioneers.rest.models.entities.Student;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class StudentRepository {
    public static final Map<UUID, Student> STUDENTS_DB = new ConcurrentHashMap<>();

    public static void findRegisteredStudent(StudentRegister studentRegisterRequest) throws RegisterException {
        STUDENTS_DB.values()
                .stream()
                .filter(student -> student.getEmail().equals(studentRegisterRequest.getEmail()))
                .findFirst().ifPresent(student -> {
                    throw new RegisterException("Email already registered");
                });
    }

    public static void saveStudent(final Student student) {
        STUDENTS_DB.put(student.getId(), student);
    }


}
