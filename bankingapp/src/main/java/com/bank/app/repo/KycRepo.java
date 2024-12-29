package com.bank.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.app.model.KycDoc;
import com.bank.app.model.User;
import com.bank.app.repo.custom.KycRepoCustom;

@Repository
public interface KycRepo extends JpaRepository<KycDoc, Long>, KycRepoCustom {
	
	KycDoc findByUserObj(User user);
	
	@Query("SELECT k FROM KycDoc k WHERE k.userObj=?1 AND k.documentType=?2")
	KycDoc getDocUniqueId(User usrId, String typ);

}
