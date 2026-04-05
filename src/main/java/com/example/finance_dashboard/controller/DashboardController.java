package com.example.finance_dashboard.controller;

import org.springframework.web.bind.annotation.*;

import com.example.finance_dashboard.model.Record;
import com.example.finance_dashboard.service.RecordService;

import java.util.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final RecordService service;

    public DashboardController(RecordService service) {
        this.service = service;
    }

    @GetMapping("/summary")
    public Map<String, Double> summary() {

        // ✅ Use your own Record class (NOT java.lang.Record)
        List<Record> records = service.getAll();

        double income = records.stream()
                .filter(r -> r.getType().name().equals("INCOME"))
                .mapToDouble(Record::getAmount)
                .sum();

        double expense = records.stream()
                .filter(r -> r.getType().name().equals("EXPENSE"))
                .mapToDouble(Record::getAmount)
                .sum();

        return Map.of(
                "income", income,
                "expense", expense,
                "balance", income - expense
        );
    }
}