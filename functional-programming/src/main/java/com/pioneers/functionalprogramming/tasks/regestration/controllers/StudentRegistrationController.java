package com.pioneers.functionalprogramming.tasks.regestration.controllers;

import com.pioneers.functionalprogramming.tasks.regestration.models.dtos.requests.RegistrationRequest;
import com.pioneers.functionalprogramming.tasks.regestration.services.RegistrationResult;
import com.pioneers.functionalprogramming.tasks.regestration.services.StudentRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentRegistrationController {

    private final StudentRegistrationService studentRegistrationService;

    @PostMapping("register")
    public ResponseEntity<String> registerApi(@RequestBody RegistrationRequest registrationRequest) {

        final RegistrationResult registrationResult = studentRegistrationService.register(registrationRequest);
        final AtomicReference<ResponseEntity<String>> atomicReference = new AtomicReference<>();

        registrationResult.onSuccess(message -> atomicReference.set(ResponseEntity.ok(message)));
        registrationResult.onFailure(message -> atomicReference.set(ResponseEntity.badRequest().body(message)));

        return atomicReference.get();
    }
}
