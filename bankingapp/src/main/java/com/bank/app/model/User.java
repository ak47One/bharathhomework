package com.bank.app.model;

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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "user_dtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	@JsonIgnore
	private Long userId;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "EMAIL_ID", nullable = false, unique = true)
	private String emailId;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "PHONE_NO", nullable = false, unique = true)
	private String phoneNo;

	@JsonIgnore
	@OneToMany(mappedBy = "userObject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	Set<Transaction> accntTransLst;

	@JsonIgnore
	@OneToMany(mappedBy = "userObj", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	Set<KycDoc> kycList;

	@ManyToMany(mappedBy = "users")
	@JsonIgnore
	private Set<Loan> loans;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private AccountDetails accountDetails;

}
