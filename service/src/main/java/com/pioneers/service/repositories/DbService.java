package com.pioneers.service.repositories;

import com.pioneers.service.models.entities.Student;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface DbService {

    void save(final Student student);

    void update(final UUID id, final Student student);

    void delete(final UUID id);

    void clear();

    Optional<Student> findByEmail(final String email);

    Optional<Student> findById(final UUID id);

    Collection<Student> findAll();
}
