package com.pioneers.rest.controllers;

import com.pioneers.rest.models.dtos.requests.StudentRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("welcome")
public class WelcomeController {

    @GetMapping("student/pathVaiable/{name}")
    public String welcomeStudentWithPathVariableApi(@PathVariable(name = "name") String studentName) {
        return "<h1>Welcome " + studentName + " to Advanced Java and Spring Boot with Docker diploma!!</h1>";
    }

    @GetMapping("student/requestParam")
    public String welcomeStudentWithRequestParamApi(@RequestParam(name = "name", required = true) String studentName) {
        return "<h1>Welcome " + studentName + " to Advanced Java and Spring Boot with Docker diploma!!</h1>";
    }

    @PostMapping("student/requestBody")
    public String welcomeStudentWithRequestBodyApi(@RequestBody StudentRequest studentRequest) {
        return "Welcome " + studentRequest.getName() + " to Advanced Java and Spring Boot with Docker diploma!!\n" +
                "Age: " + studentRequest.getAge() + ", Email: " + studentRequest.getEmail();
    }
}
