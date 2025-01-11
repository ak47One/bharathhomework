package com.bank.app.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="emply_dtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long emplyId;
	
	@Column(name="EMPLY_USERNAME")
	private String emplyUserName;
	
	@Column(name="EMPLY_PASSWORD")
	private String emplyPassword;
	
	@Column(name="EMPLY_JOINED_DATE")
	private LocalDateTime emplyJoinedDate;
	
	@Column(name="EMPLY_LAST_LOGIN_DATE")
	private LocalDateTime emplyLastLoginDate;
}
