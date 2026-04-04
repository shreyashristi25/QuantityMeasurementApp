package com.quantitymeasurement.auth.service;

import com.quantitymeasurement.auth.auth.entity.User;
import com.quantitymeasurement.auth.auth.repository.UserRepository;
import com.quantitymeasurement.auth.exception.UserAlreadyExistsException;

import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(UserRepository repository,
            PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String name, String email, String password, String mobile, String role) {
        if (repository.findByUsername(email).isPresent()) {
            throw new UserAlreadyExistsException("Email already registered");
        }

        User user = new User();
        user.setName(name);
        user.setUsername(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setMobile(mobile);
        user.setRole(role);

        return repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}