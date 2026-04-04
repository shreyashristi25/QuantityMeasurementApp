package com.quantitymeasurement.history.controller;

import com.quantitymeasurement.history.entity.HistoryEntity;
import com.quantitymeasurement.history.repository.HistoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    private final HistoryRepository repository;

    public HistoryController(HistoryRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<HistoryEntity> save(@RequestBody HistoryEntity entity,
                                              @RequestHeader(value = "X-User-Name", required = false) String username) {
        entity.setUsername(username != null ? username : "anonymous");
        entity.setTimestamp(LocalDateTime.now());
        return ResponseEntity.ok(repository.save(entity));
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<HistoryEntity>> getUserHistory(@PathVariable String username) {
        return ResponseEntity.ok(repository.findByUsernameOrderByTimestampDesc(username));
    }
}