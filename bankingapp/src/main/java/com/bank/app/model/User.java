package com.bank.app.model;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="user_dtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	@JsonIgnore
	private Long id;

	@Column(name="FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name="LAST_NAME", nullable = false)
	private String lastName;

	@Column(name="EMAIL_ID", nullable = false, unique = true)
	private String emailId;

	@Column(name="PHONE_NO", nullable = false, unique = true)
	private String phoneNo;

	@Column(name="ACCNT_NUM", nullable = false, unique = true)
	private String accntNum;

	@Column(name="ACCNT_BAL", precision = 10, scale = 2)
	 private BigDecimal accntBalance;
	
	@JsonIgnore
	@Column(name="ACCNT_OPEN_DATE", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date accntOpenDate;
	
	@JsonIgnore
	@Column(name="ACCNT_UPDT_DATE", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date accntUpdtDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	Set<Transaction> accntTransLst;
	
}
