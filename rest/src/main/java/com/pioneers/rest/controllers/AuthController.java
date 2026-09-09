package com.pioneers.rest.controllers;

import com.pioneers.rest.errors.exceptions.CredentialsException;
import com.pioneers.rest.models.dtos.requests.StudentLogin;
import com.pioneers.rest.models.dtos.requests.StudentRegister;
import com.pioneers.rest.models.dtos.responses.GenericResponse;
import com.pioneers.rest.models.dtos.responses.StudentResponse;
import com.pioneers.rest.models.entities.Student;

import com.pioneers.rest.utils.mappers.StudentMapper;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Controller
@RequestMapping("auth")
public class AuthController {

    public AuthController() {
        log.debug("In AuthController()");
    }

    @PostMapping("signup")
    public ResponseEntity<List<String>> registerStudentApi(
            @RequestBody final StudentRegister studentRegisterRequest
    ) {
        final String methodName = "registerStudentApi";
        log.info("{}, Implementing Registration flow for [{}]", methodName, studentRegisterRequest.email());
        final ResponseEntity<List<String>> errorsResponseEntities = validateStudentRegisterRequest(studentRegisterRequest);

        final List<String> errors = errorsResponseEntities.getBody();

        if (!errors.isEmpty()) {
            log.error("{}, Errors in registerStudentApi for [{}] due to: [{}]",
                    methodName, studentRegisterRequest.email(), errors);
            return ResponseEntity.badRequest().body(errors);
        }

        final Optional<Student> optionalStudent = findByEmail(studentRegisterRequest.email());

        if (optionalStudent.isPresent()) {
            log.error("{}, Errors in registerStudentApi for email [{}], due to account is already registered",
                    methodName, studentRegisterRequest.email());
            return ResponseEntity.badRequest().body(List.of("Student already registered"));
        }

        final String fullName =
                buildFullName(studentRegisterRequest.firstName(), studentRegisterRequest.secondName());

        final String hashedPassword;
        try {
            hashedPassword = hashPassword(studentRegisterRequest.password());
        } catch (CredentialsException e) {
            log.error("{}, Cannot hash the [{}] user password due to: [{}]",
                    methodName, studentRegisterRequest.email(), e.getMessage());
            return ResponseEntity.badRequest().build();
        }

        final Student student =
                new Student(UUID.randomUUID(), fullName, studentRegisterRequest.age(),
                        studentRegisterRequest.email(), hashedPassword, false, 0.0F, 0.0F);

        save(student);

        log.info("{}, Successfully registered student with email [{}]", methodName, student.getEmail());

        return ResponseEntity
                .ok(List.of("Successfully registered student with email: " + studentRegisterRequest.email()));
    }

    @PostMapping("login")
    public ResponseEntity<String> loginApi(@RequestBody StudentLogin studentLoginRequest) {
        final Optional<Student> optionalFoundStudent = findByEmail(studentLoginRequest.email());

        if (optionalFoundStudent.isEmpty()) {
            return ResponseEntity.badRequest().body("Student with email: " + studentLoginRequest.email() + " not registered");
        }

        final Student foundStudent = optionalFoundStudent.get();
        if (foundStudent.isLoggedIn()) {
            return ResponseEntity.badRequest().body("Student already logged in");
        }

        final String hashedPassword = hashPassword(studentLoginRequest.password());

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
            Optional<Student> optionalStudent = findByEmail(request.email());
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
