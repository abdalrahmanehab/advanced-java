package com.pioneers.rest.controllers;

import com.pioneers.rest.errors.exceptions.CredentialsException;
import com.pioneers.rest.models.dtos.requests.StudentLogin;
import com.pioneers.rest.models.dtos.requests.StudentRegister;
import com.pioneers.rest.models.dtos.requests.StudentUpdate;
import com.pioneers.rest.models.dtos.responses.StudentResponse;
import com.pioneers.rest.models.entities.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.pioneers.rest.repositories.StudentRepository.*;
import static com.pioneers.rest.utils.CredentialsHelper.hashPassword;
import static com.pioneers.rest.utils.NameBuilder.buildFullName;
import static com.pioneers.rest.utils.validators.StudentValidator.validateStudentRegisterRequest;

/**
 * Create a system for a university including signup, login, logout APIs.
 * Create API to Register multiple students.
 * Create some APIs delete, update students and find the student.
 * Create some APIs to filter students who passed the final exam, and the student ranked the first among his mates.
 */
@Controller
@RequestMapping("student")
public class StudentController {

    //    @RequestMapping(value = "save", method = RequestMethod.POST)
    @PostMapping("signup")
    public ResponseEntity<List<String>> registerStudentApi(
            @RequestBody final StudentRegister studentRegisterRequest
    ) {
        final ResponseEntity<List<String>> errorsResponseEntities = validateStudentRegisterRequest(studentRegisterRequest);

        final List<String> errors = errorsResponseEntities.getBody();

        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors);
        }

        final Optional<Student> optionalStudent = findByEmail(studentRegisterRequest.getEmail());

        if (optionalStudent.isPresent()) {
            return ResponseEntity.badRequest().body(List.of("Student already registered"));
        }

        final String fullName =
                buildFullName(studentRegisterRequest.getFirstName(), studentRegisterRequest.getSecondName());

        final String hashedPassword;
        try {
            hashedPassword = hashPassword(studentRegisterRequest.getPassword());
        } catch (CredentialsException e) {
            return ResponseEntity.badRequest().build();
        }

        final Student student =
                new Student(UUID.randomUUID(), fullName, studentRegisterRequest.getAge(),
                        studentRegisterRequest.getEmail(), hashedPassword, false, 0.0F, 0.0F);

        save(student);

        return ResponseEntity
                .ok(List.of("Successfully registered student with email: " + studentRegisterRequest.getEmail()));
    }

    @PostMapping("login")
    public ResponseEntity<String> loginApi(@RequestBody StudentLogin studentLoginRequest) {
        final Optional<Student> optionalFoundStudent = findByEmail(studentLoginRequest.getEmail());

        if (optionalFoundStudent.isEmpty()) {
            return ResponseEntity.badRequest().body("Student with email: " + studentLoginRequest.getEmail() + " not registered");
        }

        final Student foundStudent = optionalFoundStudent.get();
        if (foundStudent.isLoggedIn()) {
            return ResponseEntity.badRequest().body("Student already logged in");
        }

        final String hashedPassword = hashPassword(studentLoginRequest.getPassword());

        if (!hashedPassword.equals(foundStudent.getPassword())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Passwords don't match");
        }

        foundStudent.setLoggedIn(true);

        return ResponseEntity.ok("Student with email: " + foundStudent.getEmail() + " logged in successfully!!");
    }

    @PostMapping("logout")
    public ResponseEntity<String> logoutApi(@RequestParam String email) {
        final Optional<Student> optionalFoundStudent = findByEmail(email);

        if (optionalFoundStudent.isEmpty()) {
            return ResponseEntity.badRequest().body("Student with email: " + email + " not registered");
        }

        final Student foundStudent = optionalFoundStudent.get();

        if (!foundStudent.isLoggedIn()) {
            return ResponseEntity.badRequest().body("Student not logged in");
        }

        foundStudent.setLoggedIn(false);

        return ResponseEntity.ok("Successfully logged out!");
    }

    // TODO: Enhance this API to prevent saving the already registered students, and return the error response for the
    //  students who haven't registered
    @PostMapping("saveAll")
    public ResponseEntity<String> saveAllApi(@RequestBody List<StudentRegister> studentRegisterRequests) {
        studentRegisterRequests.forEach(this::registerStudentApi);
        return ResponseEntity.ok("Successfully all students successfully!");
    }

    @GetMapping("findAll")
    public ResponseEntity<?> findAllStudentsApi() {
        final Collection<Student> sortedStudentsByAge = findAllSortedByAge();

        if (sortedStudentsByAge.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Db is empty");
        }

        // Bad practice because it violates the Tell Don't Ask (TDA) principle
        /*final Collection<Student> sortedStudents = sortedStudentsByAge.stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .toList();*/

        final Collection<StudentResponse> studentResponses = sortedStudentsByAge.stream()
                .map(StudentController::toStudentResponse)
                .toList();

        return ResponseEntity.ok(studentResponses);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<?> findByIdApi(@PathVariable UUID id) {
        final Optional<Student> optionalFoundStudent = findById(id);

        if (optionalFoundStudent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }

        final StudentResponse studentResponse = toStudentResponse(optionalFoundStudent.get());
        return ResponseEntity.ok(studentResponse);
    }

    @GetMapping("findAllSucceededStudents")
    public ResponseEntity<?> findAllSucceededStudentsApi() {
        final Collection<Student> succeededStudents = findAllSucceeded();

        if (succeededStudents.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No succeeded students found");
        }

        final Collection<StudentResponse> succeededStudentsResponse = succeededStudents.stream()
                .map(StudentController::toStudentResponse)
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

    private static StudentResponse toStudentResponse(final Student student) {
        return new StudentResponse(student.getFullName(), student.getAge(), student.getEmail());
    }
}
