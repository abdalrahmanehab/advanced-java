package com.pioneers.universitysystem.services;

import com.pioneers.universitysystem.models.dtos.requests.LoginRequest;
import com.pioneers.universitysystem.models.dtos.requests.SignupRequest;
import com.pioneers.universitysystem.models.entities.User;
import com.pioneers.universitysystem.repositories.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signup(SignupRequest req) {
        if (userRepository.isUserExist(req.getUsername(),req.getEmail())) {
            throw new RuntimeException("user is already registered");
        }
        User user = new User(req.getFullName(), req.getEmail(), req.getUsername(), req.getPassword(), req.getBirthDate());
        user.setId(userRepository.getUserNumber()+ 1);
        user.setLoggedIn(true);
        userRepository.save(user);
        return user;
    }

    public User login(LoginRequest req) {
        User user = userRepository
                .findByUsername(req.getUsername()).orElseThrow(() -> new RuntimeException("this username is not registered !"));
        if (user.isLoggedIn()) {
            throw new RuntimeException("user is already loggedin");
        }
        if (req.getPassword().equals(user.getPassword())) {
            user.setLoggedIn(true);
            return user;
        }

        throw new RuntimeException("password is incorrect try agin");
    }

    public User logout(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("user not found!"));

        user.setLoggedIn(false);
        return user;
    }
}