package com.bank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.app.DTO.TransactionDTO;
import com.bank.app.service.TransactionnService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionnService transService;

	/*
	 * PostMapping("/addTransaction") public String addTransaction(@RequestBody
	 * TransactionDTO transDTO) { if(transDTO != null) { return
	 * transService.updtAccntBalance(transDTO); }
	 * 
	 * return "Transaction Update Failed";
	 * 
	 * }
	 */

	@PostMapping("/addTransaction")
	public ResponseEntity<String> createTransaction(@RequestBody TransactionDTO transactionDTO) {
		try {
			String response = transService.createTransaction(transactionDTO);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

}
