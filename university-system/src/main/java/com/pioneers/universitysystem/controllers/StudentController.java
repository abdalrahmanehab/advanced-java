package com.pioneers.universitysystem.controllers;


import com.pioneers.universitysystem.models.dtos.requests.StudentRequest;
import com.pioneers.universitysystem.models.entities.Student;
import com.pioneers.universitysystem.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/singleReq")
    public String registerStudent(@RequestBody StudentRequest student){
        studentService.registerStudent(student);
        return "Student with name : " + student.getName() + " has been registered";
    }

    @PostMapping("/multipleReqs")
    public String registerMultipleStudents(@RequestBody List<StudentRequest> students){
        studentService.registerMultipleStudents(students);
        return "Your list of students had been registered";
    }

    @GetMapping("/allStudents")
    public List<Student> getAllStudents (){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/top")
    public Student getTopStudent() {
        return studentService.getTopStudent();
    }

    @GetMapping("/passed")
    public List<Student> getPassedStudents(){
        return studentService.getPassedStudents();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentByID (@PathVariable (value = "id") int std_id) {
        boolean isDeleted = studentService.deleteStudentByID(std_id);
        if(isDeleted) {
            return "Student with id " + std_id + " has been deleted";
        }
        return "student with id " + std_id + " is not found";
    }



}