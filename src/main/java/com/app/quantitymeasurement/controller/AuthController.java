package com.app.quantitymeasurement.controller;

import com.app.quantitymeasurement.auth.entity.User;
import com.app.quantitymeasurement.security.JwtUtil;
import com.app.quantitymeasurement.service.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String register(@RequestBody User user) {

        userService.registerUser(
            user.getUsername(),
            user.getPassword(),
            "USER"
        );

        return "User registered successfully";
    }
    
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword()
            )
        );

        return jwtUtil.generateToken(user.getUsername());
    }
}