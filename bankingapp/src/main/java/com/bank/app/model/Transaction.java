package com.bank.app.model;


import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="trans_dtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TRANS_ID")
	@JsonIgnore
	private Long transId;
	
	@Column(name="TRANS_AMOUNT", precision = 10, scale = 2)
	private BigDecimal transAmount;
	
	@Column(name="TRANS_DATE", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transDate;
	
	@Column(name="PAYMENT_TYPE")
	private String paymentType;
	
	@Column(name="TRANS_REF_ID")
	private String transReferId;
	
	@Column(name="TRANS_TYPE", nullable = false)
	private String transType;
	
	@Column(name="TRANS_STATUS")
	private String transStatus;
	
	@Column(name="PAYEE_ACCNT_NO")
	private String payeeAccntNo;
		
	@Column(name="PAYEE_NAME")
	private String payeeName;
		
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="USER_OBJECT", nullable = false)
	private User userObject;
	
	@Transient
	private String payerId;
	
}
