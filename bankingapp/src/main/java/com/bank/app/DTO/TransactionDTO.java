package com.bank.app.DTO;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

	private String payeeName;

	private String payeeAccNo;

	private String payerAccntNo;

	private String payerName;

	private Date transDate;

	private String modeOfPayment;

	private BigDecimal transAmount;

	private String transType;
	
	private String transReferId;

	private String transStatus;

}