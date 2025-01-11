package com.bank.app.DTO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

	private Long custmrId;
	
	private String custmrFirstName;
	
	private String custmrLastName;
	
	private String custmrEmailId;
	
	private String custmrPhoneNo;
	
	private List<TransactionDTO> transList;
		
}
