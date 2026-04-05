package com.example.finance_dashboard.service;


import org.springframework.stereotype.Service;

import com.example.finance_dashboard.model.User;
import com.example.finance_dashboard.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User create(User user) {
        return repo.save(user);
    }

    public List<User> getAll() {
        return repo.findAll();
    }
}
