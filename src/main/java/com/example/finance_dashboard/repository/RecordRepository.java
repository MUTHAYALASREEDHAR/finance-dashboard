package com.example.finance_dashboard.repository;

import com.example.finance_dashboard.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
}
