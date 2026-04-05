package com.example.finance_dashboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import com.example.finance_dashboard.model.Record;

import com.example.finance_dashboard.security.AuthUtil;
import com.example.finance_dashboard.service.RecordService;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService service;

    public RecordController(RecordService service) {
        this.service = service;
    }

    @PostMapping
    public Record create(@RequestBody Record r, HttpServletRequest req) {
        AuthUtil.checkAdmin(req);
        return service.create(r);
    }

    @GetMapping
    public List<Record> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, HttpServletRequest req) {
        AuthUtil.checkAdmin(req);
        service.delete(id);
    }
}
