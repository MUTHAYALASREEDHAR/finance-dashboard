package com.example.finance_dashboard.controller;


import org.springframework.web.bind.annotation.*;

import com.example.finance_dashboard.model.User;
import com.example.finance_dashboard.repository.UserRepository;
import com.example.finance_dashboard.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository repo;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository repo, JwtUtil jwtUtil) {
        this.repo = repo;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser = repo.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return jwtUtil.generateToken(dbUser.getEmail(), dbUser.getRole().name());
    }
}
