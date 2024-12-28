package com.bank.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "kyc_dtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KycDoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long kycId;
	
	private String documentType;
	
	@Column(unique = true, nullable = false)
	private String docUniqueId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="userObj",nullable = false)
	private User userObj;

}
