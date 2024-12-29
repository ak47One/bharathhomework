package com.bank.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.app.model.KycDoc;
import com.bank.app.model.User;
import com.bank.app.repo.custom.KycRepoCustom;

@Repository
public interface KycRepo extends JpaRepository<KycDoc, Long>, KycRepoCustom {
	
	KycDoc findByUserObj(User user);

}
