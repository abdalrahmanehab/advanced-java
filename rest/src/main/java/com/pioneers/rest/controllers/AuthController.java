package com.pioneers.rest.controllers;

import com.pioneers.rest.errors.exceptions.CredentialsException;
import com.pioneers.rest.models.dtos.requests.StudentLogin;
import com.pioneers.rest.models.dtos.requests.StudentRegister;
import com.pioneers.rest.models.dtos.responses.GenericResponse;
import com.pioneers.rest.models.dtos.responses.StudentResponse;
import com.pioneers.rest.models.entities.Student;

import com.pioneers.rest.utils.mappers.StudentMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.pioneers.rest.repositories.StudentRepository.findByEmail;
import static com.pioneers.rest.repositories.StudentRepository.save;
import static com.pioneers.rest.utils.CredentialsHelper.hashPassword;
import static com.pioneers.rest.utils.NameBuilder.buildFullName;
import static com.pioneers.rest.utils.validators.StudentValidator.validateStudentRegisterRequest;

@Controller
@RequestMapping("auth")
public class AuthController {
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
    public ResponseEntity<GenericResponse<String>> logoutApi(@RequestParam String email) {
        final Optional<Student> optionalFoundStudent = findByEmail(email);

        if (optionalFoundStudent.isEmpty()) {
            return ResponseEntity.badRequest().body(new GenericResponse<>("Student with email: " + email + " not registered", null));
        }

        final Student foundStudent = optionalFoundStudent.get();

        if (!foundStudent.isLoggedIn()) {
            return ResponseEntity.badRequest().body(new GenericResponse<>("Student not logged in", null));
        }

        foundStudent.setLoggedIn(false);

        return ResponseEntity.ok(new GenericResponse<>("Successfully logged out!", null));
    }

    @PostMapping("saveAll")
    public ResponseEntity<?> saveAllApi(@RequestBody List<StudentRegister> studentRegisterRequests) {
        final List<Student> registeredStudents = new ArrayList<>();

        studentRegisterRequests.forEach(request -> {
            Optional<Student> optionalStudent = findByEmail(request.getEmail());
            if (optionalStudent.isPresent()) {
                registeredStudents.add(optionalStudent.get());
                return;
            }
            registerStudentApi(request);
        });

        if (registeredStudents.isEmpty()) {
            return ResponseEntity.ok("Successfully all registeredStudents successfully!");
        }

        final List<StudentResponse> rejectedStudentsList = registeredStudents.stream()
                .map(StudentMapper::toStudentResponse)
                .toList();

        final GenericResponse<List<StudentResponse>> genericResponse =
                new GenericResponse<>("Those list are rejected to be inserted", rejectedStudentsList);

        return ResponseEntity.ok().body(genericResponse);
    }
}
