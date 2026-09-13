package com.pioneers.service.repositories;

import com.pioneers.service.models.entities.Student;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface StudentRepository {

    void save(final Student student);

    void deleteById(final UUID id);

    void deleteAll();

    void update(final Student student);

    Optional<Student> findByEmail(final String email);

    Optional<Student> findById(final UUID id);

    Collection<Student> findAllSortedByAge();

    Collection<Student> findAllSucceeded();
}
