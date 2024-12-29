package com.bank.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bank.app.model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

}
