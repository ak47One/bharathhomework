package com.bank.app.service;

import com.bank.app.DTO.NewCustomerRegisterationDTO;
import com.bank.app.model.Customer;

public interface RegistrationService {
	
	 public String crateCustomerAndAccout(NewCustomerRegisterationDTO dto);

}