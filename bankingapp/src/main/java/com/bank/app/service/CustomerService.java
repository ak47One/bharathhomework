package com.bank.app.service;

import java.util.List;

import com.bank.app.model.Customer;

public interface CustomerService {

    // Retrieve a user by ID
    public Customer getUser(Long id);

    // Add a new user
    public Customer addUser(Customer custmr);
    
    public String checkBalance(String accountNo);
    
    public List<Customer> last3acnt();
    
    public String getBankBal();
}

