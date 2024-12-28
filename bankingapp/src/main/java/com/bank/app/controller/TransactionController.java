package com.bank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.app.DTO.TransactionDTO;
import com.bank.app.model.Transaction;
import com.bank.app.model.User;
import com.bank.app.repo.UserRepo;

@RestController
public class TransactionController {
	
	
	@Autowired
	private UserRepo userRepo;
	
	 @PostMapping("/addTransaction")
	    public String addTransaction(@RequestBody TransactionDTO transDTO) {
		 if(transDTO != null) {
			 User user = userRepo.findByUserId(Long.parseLong(transDTO.getPayerId()));
		 }
		 
		 return "Transaction Updated Successfully";
		 
	 }

}
