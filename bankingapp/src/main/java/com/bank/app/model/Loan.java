package com.bank.app.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "loan_dtl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOAN_ID")
    private Long loanId;

    @Column(name = "LOAN_TYPE", nullable = false)
    private String loanType;

    @Column(name = "PRINCIPAL_AMOUNT", nullable = false, precision = 10, scale = 2)
    private BigDecimal principalAmount;
    
    @Column(name ="RATE_OF_INTEREST", nullable = false)
    private BigDecimal rateOfInterest;
    
    @Column(name ="LOAN_TENURE", nullable = false)
    private Long loanTenure;
    
    @Column(name="TOTAL_INTEREST_AMOUNT", nullable = false)
    private BigDecimal totalInterest;
    
    @Column(name ="EMI_AMOUNT")
    private BigDecimal monthlyEMI;
    
    @Column(name="LOAN_START_DATE")
    @CreationTimestamp
    private LocalDateTime loanStartDate;
    
    @Column(name = "LOAN_MANTURITY_DATE")
    private LocalDateTime loanManturityDate;
    
    @ManyToMany
    @JoinTable(
        name = "custmr_loan",
        joinColumns = @JoinColumn(name = "LOAN_ID"),
        inverseJoinColumns = @JoinColumn(name = "CUSTMR_ID")
    )
    private Set<Customer> customers = new HashSet<>();
}
