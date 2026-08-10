package com.pioneers.rest.repositories;

import com.pioneers.rest.models.entities.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StudentRepository {

    private static final Logger log = LoggerFactory.getLogger(StudentRepository.class);

    public static final Map<UUID, Student> STUDENTS_DB = new ConcurrentHashMap<>();

    public static void save(final Student student) {
        STUDENTS_DB.put(student.getId(), student);
        log.info("Saved student with email = [{}] and id = [{}]", student, student.getId());
    }

    public static void delete(final UUID id) {
        STUDENTS_DB.remove(id);
    }

    public static void deleteAll() {
        STUDENTS_DB.clear();
    }

    public static void update(final Student student) {
        STUDENTS_DB.put(student.getId(), student);
        log.debug("Updated student with email = [{}] and id = [{}]", student, student.getId());
    }

    public static Optional<Student> findByEmail(final String email) {
        return STUDENTS_DB.values()
                .stream()
                .filter(student -> student.getEmail().equals(email))
                .findFirst();
    }

    public static Optional<Student> findById(final UUID id) {
        return Optional.ofNullable(STUDENTS_DB.get(id));
    }

    public static Collection<Student> findAllSortedByAge() {
        return STUDENTS_DB.values()
                .stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .toList();
    }

    public static Collection<Student> findAllSucceeded() {
        return STUDENTS_DB.values()
                .stream()
                .filter(Student::isPassedExam)
                .toList();
    }
}
