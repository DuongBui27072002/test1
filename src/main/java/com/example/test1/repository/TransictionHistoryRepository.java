package com.example.test1.repository;

import com.example.test1.entity.TransictionHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransictionHistoryRepository extends JpaRepository<TransictionHistoryEntity, Integer> {
}
