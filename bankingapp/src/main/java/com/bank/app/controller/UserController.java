package com.bank.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bank.app.model.User;
import com.bank.app.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/testing")
    public String test() {
        return "Application is running!";
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }


    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
    	if(user != null) {
    		user.setAccntOpenDate(new Date());
    		user.setAccntUpdtDate(new Date());
    	}
        return userService.addUser(user);
    }
     
    @GetMapping("/checkBalance")
    public String checkBalance(@RequestParam String accountNo) {
		return userService.checkBalance(accountNo);
    	
    }
    @GetMapping("/last3Accnt")
    public List<User> last3Accnt() {
		return userService.last3acnt();
    	
    }
    @GetMapping("/BankBal")
    public String getBankBal() {
		return userService.getBankBal();
    	
    }
    
    
}
