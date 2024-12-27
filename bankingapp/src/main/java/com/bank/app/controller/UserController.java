package com.bank.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bank.app.model.User;
import com.bank.app.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("/testing")
    public String test() {
        return "Application is running!";
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return service.getUser(id);
    }


    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
    	if(user != null) {
    		user.setAccntOpenDate(new Date());
    		user.setAccntUpdtDate(new Date());
    	}
        return service.addUser(user);
    }
}
