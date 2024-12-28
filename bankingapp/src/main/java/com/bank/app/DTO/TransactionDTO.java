package com.bank.app.DTO;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDTO {
	
	private Long transId;
	
	private BigDecimal transAmount;
	
	private String transType;
	
	private String paymentType;
	
	private String payeeAccntNo;
	
	private String payeeName;

	private String transReferId;
	
	private String transStatus;
	
	private String payerId;
}
