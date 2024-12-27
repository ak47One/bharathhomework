package com.bank.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.model.User;
import com.bank.app.repo.UserRepo;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    // Retrieve a user by ID
    public User getUser(Long id) {
        Optional<User> userOptional = repo.findById(id);
        return userOptional.orElseThrow(() ->
                new RuntimeException("User not found with ID: " + id));
    }

    // Add a new user
    public User addUser(User user) {
        return repo.save(user);
    }
}

