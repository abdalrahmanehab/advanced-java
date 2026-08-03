package com.pioneers.rest.controllers;

import com.pioneers.rest.errors.exceptions.CredentialsException;
import com.pioneers.rest.errors.exceptions.RegisterException;
import com.pioneers.rest.models.dtos.requests.StudentRegister;
import com.pioneers.rest.models.entities.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

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

    // TODO: Edit this method to return the cause of the error!!
//    @RequestMapping(value = "save", method = RequestMethod.POST)
    @PostMapping("save")
    public ResponseEntity<Map<UUID, Student>> registerStudentApi(
            @RequestBody final StudentRegister studentRegisterRequest
    ) {
        Optional<ResponseEntity<Map<UUID, Student>>> optional = validateStudentRegisterRequest(studentRegisterRequest);
        if (optional.isPresent()) {
            return optional.get();
        }

        try {
            findRegisteredStudent(studentRegisterRequest);
        } catch (RegisterException e) {
            return ResponseEntity.badRequest().build();
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

        saveStudent(student);
        return ResponseEntity.ok(STUDENTS_DB);
    }
}
