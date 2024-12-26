package com.BankUser.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private int phone;
    @Column(nullable = false, unique = true)
    private int accountNumber;
    private double balance;

    public User(String firstName, String lastName, String email, int phone, int accountNumber, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
