package com.pioneers.service.controllers;

import com.pioneers.service.errors.exceptions.StudentException;
import com.pioneers.service.models.dtos.requests.StudentUpdate;
import com.pioneers.service.models.dtos.responses.GenericResponse;
import com.pioneers.service.models.dtos.responses.StudentResponse;
import com.pioneers.service.services.students.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Create a system for a university including signup, login, logout APIs.
 * Create API to Register multiple students.
 * Create some APIs delete, update students and find the student.
 * Create some APIs to filter students who passed the final exam, and the student ranked the first among his mates.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    // TODO: I need respond back to the client with each HTTP Status
    @GetMapping("findAll")
    public List<StudentResponse> findAllStudentsApi() {
        return studentService.findAllSortedByAge();
    }

    @GetMapping("findById/{id}")
    public StudentResponse findByIdApi(@PathVariable UUID id) {
        return studentService.findById(id);
    }

    @GetMapping("findAllSucceededStudents")
    public Collection<StudentResponse> findAllSucceededStudentsApi() {
        return studentService.findAllSucceeded();
    }

    @PutMapping("update/{id}")
    public String updateApi(@PathVariable UUID id, @RequestBody StudentUpdate studentUpdateRequest) {
        studentService.update(id, studentUpdateRequest);

        return "Successfully updated student with email: " + studentUpdateRequest.email();
    }

    @DeleteMapping("delete")
    public String deleteApi(@RequestParam UUID id) {
        final StudentResponse studentResponse = studentService.findById(id);

        studentService.deleteById(id);

        return "Successfully deleted student with email: " + studentResponse.email();
    }

    @DeleteMapping("deleteAll")
    public String deleteAllApi() {
        studentService.deleteAll();

        return "Successfully deleted all students";
    }
}
