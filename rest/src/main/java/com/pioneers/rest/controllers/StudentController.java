package com.pioneers.rest.controllers;

import com.pioneers.rest.models.dtos.requests.StudentUpdate;
import com.pioneers.rest.models.dtos.responses.GenericResponse;
import com.pioneers.rest.models.dtos.responses.StudentResponse;
import com.pioneers.rest.models.entities.Student;
import com.pioneers.rest.utils.mappers.StudentMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.pioneers.rest.repositories.StudentRepository.*;
import static com.pioneers.rest.utils.CredentialsHelper.hashPassword;
import static com.pioneers.rest.utils.NameBuilder.buildFullName;

/**
 * Create a system for a university including signup, login, logout APIs.
 * Create API to Register multiple students.
 * Create some APIs delete, update students and find the student.
 * Create some APIs to filter students who passed the final exam, and the student ranked the first among his mates.
 */
@Controller
@RequestMapping("student")
public class StudentController {

    @GetMapping("findAll")
    public ResponseEntity<?> findAllStudentsApi() {
        final Collection<Student> sortedStudentsByAge = findAllSortedByAge();

        if (sortedStudentsByAge.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Db is empty");
        }

        final Collection<StudentResponse> studentResponses = sortedStudentsByAge.stream()
                .map(StudentMapper::toStudentResponse)
                .toList();

        return ResponseEntity.ok(studentResponses);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<GenericResponse<StudentResponse>> findByIdApi(@PathVariable UUID id) {
        final Optional<Student> optionalFoundStudent = findById(id);

        if (optionalFoundStudent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericResponse<>("Student not found", null));
        }

        final StudentResponse studentResponse = StudentMapper.toStudentResponse(optionalFoundStudent.get());
        return ResponseEntity.ok(new GenericResponse<>("Student found", studentResponse));
    }

    @GetMapping("findAllSucceededStudents")
    public ResponseEntity<?> findAllSucceededStudentsApi() {
        final Collection<Student> succeededStudents = findAllSucceeded();

        if (succeededStudents.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No succeeded students found");
        }

        final Collection<StudentResponse> succeededStudentsResponse = succeededStudents.stream()
                .map(StudentMapper::toStudentResponse)
                .toList();

        return ResponseEntity.ok(succeededStudentsResponse);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateApi(@PathVariable UUID id, @RequestBody StudentUpdate studentUpdateRequest) {
        final Optional<Student> optionalFoundStudent = findById(id);

        if (optionalFoundStudent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }

        final String updatedFullName = buildFullName(studentUpdateRequest.getFirstName(), studentUpdateRequest.getSecondName());
        final String updatedHashedPassword = hashPassword(studentUpdateRequest.getPassword());

        final Student foundStudent = optionalFoundStudent.get();
        foundStudent.setFullName(updatedFullName);
        foundStudent.setEmail(studentUpdateRequest.getEmail());
        foundStudent.setAge(studentUpdateRequest.getAge());
        foundStudent.setPassword(updatedHashedPassword);
        foundStudent.setScore(studentUpdateRequest.getScore());

        return ResponseEntity.ok("Successfully updated student with email: " + foundStudent.getEmail());
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteApi(@RequestParam UUID id) {
        final Optional<Student> optionalFoundStudent = findById(id);

        if (optionalFoundStudent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }

        delete(id);

        return ResponseEntity.ok("Successfully deleted student with email: " + optionalFoundStudent.get().getEmail());
    }

    @DeleteMapping("deleteAll")
    public ResponseEntity<String> deleteAllApi() {

        deleteAll();

        return ResponseEntity.ok("Successfully deleted all students");
    }
}
