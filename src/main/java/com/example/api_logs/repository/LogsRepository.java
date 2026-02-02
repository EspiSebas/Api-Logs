package com.example.api_logs.repository;

import com.example.api_logs.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsRepository extends JpaRepository<LogEntity,Long> {
}
