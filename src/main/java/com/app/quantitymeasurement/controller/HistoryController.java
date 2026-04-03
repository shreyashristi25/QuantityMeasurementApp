package com.app.quantitymeasurement.controller;

import com.app.quantitymeasurement.model.QuantityMeasurementEntity;
import com.app.quantitymeasurement.repository.QuantityMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/history")
public class HistoryController {

    @Autowired
    private QuantityMeasurementRepository repository;

    @GetMapping
    public ResponseEntity<List<QuantityMeasurementEntity>> getHistory(Authentication authentication) {
        if (authentication == null) {
            return ResponseEntity.status(401).build();
        }
        String username = authentication.getName();
        List<QuantityMeasurementEntity> history = repository.findByUsernameOrderByTimestampDesc(username);
        return ResponseEntity.ok(history);
    }

    @PostMapping
    public ResponseEntity<QuantityMeasurementEntity> logOperation(@RequestBody QuantityMeasurementEntity entity, Authentication authentication) {
        String username = authentication.getName();
        entity.setUsername(username);
        entity.setTimestamp(LocalDateTime.now());
        QuantityMeasurementEntity saved = repository.save(entity);
        return ResponseEntity.ok(saved);
    }
}
