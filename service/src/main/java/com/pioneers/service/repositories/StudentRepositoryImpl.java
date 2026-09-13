package com.pioneers.service.repositories;

import com.pioneers.service.models.entities.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Repository
@RequiredArgsConstructor
public class StudentRepositoryImpl implements StudentRepository {

    private final DbService dbService;

    @Override
    public void save(final Student student) {
        final String methodName = "save";
        dbService.save(student);
        log.debug("{}, Saved student with email = [{}] and id = [{}]", methodName, student, student.getId());
    }

    @Override
    public void deleteById(final UUID id) {
        final String methodName = "delete";
        dbService.delete(id);
        log.debug("{}, deleting the student with id [{}]", methodName, id);
    }

    @Override
    public void deleteAll() {
        dbService.clear();
    }

    @Override
    public void update(final Student student) {
        dbService.save(student);
        log.debug("Updated student with email = [{}] and id = [{}]", student, student.getId());
    }

    @Override
    public Optional<Student> findByEmail(final String email) {
        return dbService.findByEmail(email);
    }

    @Override
    public Optional<Student> findById(final UUID id) {
        return dbService.findById(id);
    }

    @Override
    public Collection<Student> findAllSortedByAge() {
        return dbService.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .toList();
    }

    @Override
    public Collection<Student> findAllSucceeded() {
        return dbService.findAll()
                .stream()
                .filter(Student::isPassedExam)
                .toList();
    }
}
