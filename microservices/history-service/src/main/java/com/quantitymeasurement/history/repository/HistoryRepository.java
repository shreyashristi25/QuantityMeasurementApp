package com.quantitymeasurement.history.repository;

import com.quantitymeasurement.history.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Long> {
    List<HistoryEntity> findByUsernameOrderByTimestampDesc(String username);
}