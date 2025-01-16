package com.bank.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.model.Customer;
import com.bank.app.repo.CustomerRepo;
import com.bank.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;
    
   

    // Retrieve a user by ID
    public Customer getUser(Long id) {
        Optional<Customer> userOptional = repo.findById(id);
        return userOptional.orElseThrow(() ->
                new RuntimeException("User not found with ID: " + id));
    }

    // Add a new user
    public Customer addUser(Customer user) {
        return repo.save(user);
    }
    
    public String checkBalance(String accountNo) {
		/* return repo.findByAccntNum(accountNo); */
    	return null;
    	
    }
    public List<Customer> last3acnt() {
		/* return repo.getLatestUser(); */
		return null;
    	
    }
    public String getBankBal() {
		/* return repo.getBankBalance(); */
		return null;
    	
    }
    
    
    
  
}

