package com.bank.app.DTO;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class NewCustomerRegisterationDTO {
	
	private String custmrFirstName;
	
	private String custmrLastName;
	
	private String custmrEmailId;
	
	private String custmrPassword;
	
	private String phoneNo;
	
	private String accntType;
	
	private BigDecimal accntBalance;

}
