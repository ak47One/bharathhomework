package com.bank.app.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "account_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCNT_DTL_ID")
    private Long accntDtlId;

    @Column(name = "ACCNT_NUM", nullable = false, unique = true)
    private String accntNo;

    @Column(name = "ACCNT_BAL", precision = 10, scale = 2)
    private BigDecimal accntBalance;
    
    @Column(name = "ACCNT_TYPE", nullable = false)
    private String accntType;

    @Column(name = "ACCNT_OPEN_DATE")
    @CreationTimestamp
    private LocalDateTime accntOpenDate;

    @Column(name = "ACCNT_UPDT_DATE")
    @UpdateTimestamp
    private LocalDateTime accntUpdtDate;

    @OneToOne
    @JoinColumn(name = "CUSTMR_ID", referencedColumnName = "CUSTMR_ID")
    private Customer custmrObj;
}

