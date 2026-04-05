package com.example.finance_dashboard.service;


import org.springframework.stereotype.Service;
import com.example.finance_dashboard.model.Record;


import com.example.finance_dashboard.repository.RecordRepository;

import java.util.List;

@Service
public class RecordService {

    private final RecordRepository repo;

    public RecordService(RecordRepository repo) {
        this.repo = repo;
    }

    public Record create(Record r) {
        return repo.save(r);
    }

    public List<Record> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
