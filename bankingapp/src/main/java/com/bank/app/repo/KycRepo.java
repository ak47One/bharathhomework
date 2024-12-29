package com.bank.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.app.model.KycDoc;

@Repository
public interface KycRepo extends JpaRepository<KycDoc, Long> {

}
