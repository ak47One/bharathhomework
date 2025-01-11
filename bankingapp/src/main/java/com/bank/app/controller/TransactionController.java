package com.bank.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.app.DTO.TransactionDTO;
import com.bank.app.service.TransactionService;

@RestController
public class TransactionController {
	
	private TransactionService transService;
		
	 @PostMapping("/addTransaction")
	    public String addTransaction(@RequestBody TransactionDTO transDTO) {
		 if(transDTO != null) {
			 return transService.updtAccntBalance(transDTO);
		 }
		 
		 return "Transaction Update Failed";
		 
	 }

}
