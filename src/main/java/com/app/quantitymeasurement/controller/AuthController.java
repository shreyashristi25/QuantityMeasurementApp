package com.app.quantitymeasurement.controller;

import com.app.quantitymeasurement.dto.LoginRequest;
import com.app.quantitymeasurement.dto.RegisterRequest;
import com.app.quantitymeasurement.security.JwtUtil;
import com.app.quantitymeasurement.service.CustomUserDetailsService;

import jakarta.validation.Valid;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@Valid @RequestBody RegisterRequest request) {
        userService.registerUser(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                request.getMobile(),
                "USER");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody LoginRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));
        String token = jwtUtil.generateToken(request.getEmail());
        return ResponseEntity.ok(Map.of("token", token));
    }
}