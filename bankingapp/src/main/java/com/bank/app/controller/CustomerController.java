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

import com.bank.app.DTO.NewCustomerRegisterationDTO;
import com.bank.app.model.Customer;
import com.bank.app.service.CustomerService;
import com.bank.app.service.RegistrationService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService custmrService;

	@Autowired
	private RegistrationService regService;

	@GetMapping("/testing")
	public String test() {
		return "Application is running!";
	}

	@GetMapping("/user/{id}")
	public Customer getUser(@PathVariable Long id) {
		return custmrService.getUser(id);
	}

	@PostMapping("/user")
	public Customer addUser(@RequestBody Customer user) {
		if (user != null) {
			return custmrService.addUser(user);
		}
		return null;
	}

	@GetMapping("/checkBalance")
	public String checkBalance(@RequestParam String accountNo) {
		return custmrService.checkBalance(accountNo);

	}

	@GetMapping("/last3Accnt")
	public List<Customer> last3Accnt() {
		return custmrService.last3acnt();

	}

	@GetMapping("/BankBal")
	public String getBankBal() {
		return custmrService.getBankBal();

	}

	@PostMapping("/newCustomerRegistration")
	public String createCustomer(@RequestBody NewCustomerRegisterationDTO regDto) {
		String cusAccountNo = regService.crateCustomerAndAccout(regDto);
		return cusAccountNo;
	}

}