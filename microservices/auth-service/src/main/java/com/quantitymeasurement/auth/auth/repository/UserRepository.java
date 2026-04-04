package com.quantitymeasurement.auth.auth.repository;

import com.quantitymeasurement.auth.auth.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

}