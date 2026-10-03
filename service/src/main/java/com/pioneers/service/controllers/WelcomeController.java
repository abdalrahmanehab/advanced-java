package com.pioneers.service.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("welcome")
public class WelcomeController {

    @PostMapping("student/{name}")
    public String welcomeStudentApi(@PathVariable final String name) {
        final String methodName = "welcomeStudentApi()";
        log.info("{}, Welcome [{}]", methodName, name);
        return "Welcome " + name + " to Advanced Java and Spring Boot with Docker";
    }
}
