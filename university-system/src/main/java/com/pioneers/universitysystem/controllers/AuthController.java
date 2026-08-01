package com.pioneers.universitysystem.controllers;

import com.pioneers.universitysystem.models.dtos.requests.LoginRequest;
import com.pioneers.universitysystem.models.dtos.requests.SignupRequest;
import com.pioneers.universitysystem.models.entities.User;
import com.pioneers.universitysystem.services.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest req){
        return authService.login(req);
    }

    @PostMapping("/signup")
    public User signup(@RequestBody SignupRequest req){
        return authService.signup(req);
    }

    @PostMapping("/logout")
    public User logout(@RequestParam String username) {
        return authService.logout(username);
    }

}
