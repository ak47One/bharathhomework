package com.bank.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.app.model.Customer;
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
    public Customer getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }


    @PostMapping("/user")
    public Customer addUser(@RequestBody Customer user) {
    	if(user != null) {
    	return userService.addUser(user);
    	}
        return null;
    }
     
    @GetMapping("/checkBalance")
    public String checkBalance(@RequestParam String accountNo) {
		return userService.checkBalance(accountNo);
    	
    }
    @GetMapping("/last3Accnt")
    public List<Customer> last3Accnt() {
		return userService.last3acnt();
    	
    }
    @GetMapping("/BankBal")
    public String getBankBal() {
		return userService.getBankBal();
    	
    }
    
    
}
