package com.pioneers.jpa.repositories;

import com.pioneers.jpa.models.entities.Student;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Contract to interact with the DB throw CRUD operations.
 *
 * @author abdelaziz
 * @see com.pioneers.jpa.repositories.StudentRepositoryImpl
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    /**
     * Delete Student by the primary key.
     *
     * @param id The Primary Key and must not be {@literal null}.
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE Student s SET s.isArchived = TRUE, s.isLoggedIn = FALSE WHERE s.id = :id")
    void deleteById(@Param("id") @NonNull UUID id);

    /**
     * Delete All students from the DB.
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE Student s SET s.isArchived = TRUE, s.isLoggedIn = FALSE")
    void deleteAll();

    /**
     * Update Student in the DB.
     *
     * @param student new student need to be updated.
     */
    // TODO Fix the issue where the age is not updated!
    @Transactional
    @Modifying
    @Query("""
            UPDATE Student s
            SET s.fullName = :#{#student.fullName},
                s.age = :#{#student.age},
                s.email = :#{#student.email},
                s.password = :#{#student.password},
                s.isLoggedIn = :#{#student.isLoggedIn()},
                s.score = :#{#student.score},
                s.finalScore = :#{#student.finalScore},
                s.createdAt = :#{#student.createdAt}
            WHERE s.id = :#{#student.id}
            """)
    void update(@Param("student") Student student);

//    Optional<Student> findByEmail(String email);

    /**
     * Find all archived and non-archived students by the full name and
     * age greater than provided one in ascending order.
     *
     * @param fullName         is the value of the full_name column in the DB.
     * @param ageIsGreaterThan is the target age.
     * @return all students that match full name and have ages greater than provided age.
     */
    List<Student> findAllByFullNameAndAgeGreaterThan(String fullName, int ageIsGreaterThan);

    /**
     * Find all non-archived students sorted by their ages in ascending order.
     *
     * @return all non-archived students.
     */
    List<Student> findAllByIsArchivedIsFalseOrderByAgeAsc();

    /**
     * Find the non-archived student by his email.
     *
     * @param email provided unique email.
     * @return found optional student, Optional.empty() if not found.
     */
    Optional<Student> findByEmailAndIsArchivedIsFalse(String email);

    /**
     * Find the first registered student in the system.
     *
     * @return Optional value of student if exists; otherwise return Optional.empty().
     */
    Optional<Student> findFirstByOrderByCreatedAtAsc();

    /**
     * Find all succeeded students in their exam with more than 50%.
     *
     * @return the succeeded students.
     */
    @Query("""
            SELECT s
            FROM Student s
            WHERE s.score > s.finalScore * 0.5
              AND s.isArchived = FALSE
            """)
    Collection<Student> findAllSucceeded();
}
