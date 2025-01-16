package com.bank.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.app.model.AccountDetails;

@Repository
public interface AccountDetailsRepo extends JpaRepository<AccountDetails, Long> {

	AccountDetails findByAccntNo(String accntNum);
	
	

	@Query("SELECT MAX(a.accntDtlId) FROM AccountDetails a")
	Long findMaxAccountId();

	
	
}
