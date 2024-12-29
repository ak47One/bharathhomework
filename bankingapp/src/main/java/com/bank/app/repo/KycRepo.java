package com.bank.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.app.model.KycDoc;
import com.bank.app.model.User;
import com.bank.app.repo.custom.KycRepoCustom;

@Repository
public interface KycRepo extends JpaRepository<KycDoc, Long>, KycRepoCustom {
	
	KycDoc findByUserObj(User user);
	
//	SELECT * FROM bank_data.kyc_dtl where document_type = "AADHAAR" AND user_obj = 1;
	@Query("SELECT k FROM KycDoc k WHERE k.userObj=?1 AND k.documentType=?2")
	KycDoc getDocUniqueId(User usrId, String typ);
	
//	SELECT doc_unique_id FROM bank_data.kyc_dtl where document_type = "AADHAAR" and user_obj=1;	
	@Query("SELECT k.docUniqueId FROM KycDoc k WHERE k.userObj=?1 AND k.documentType=?2")
	String getDocId(User usrId, String typ);
	
//	SELECT * FROM bank_data.kyc_dtl where  user_obj = 1;
	@Query("SELECT k FROM KycDoc k WHERE k.userObj=?1")
	List<KycDoc> getDocUni(User usrId);
}
