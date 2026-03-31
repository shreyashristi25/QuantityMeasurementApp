package com.app.quantitymeasurement.auth.repository;

import com.app.quantitymeasurement.auth.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

}
