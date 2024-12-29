package com.bank.app.repo.customImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bank.app.model.KycDoc;
import com.bank.app.model.User;
import com.bank.app.repo.custom.KycRepoCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class KycRepoCustomImpl implements KycRepoCustom {

	private static final Logger log = LogManager.getLogger(KycRepoCustomImpl.class);

	@PersistenceContext
	EntityManager entityManager;

	public KycRepoCustomImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public KycDoc getDocUniqueId(User user, String docType) {
		try {
			String tblNam = "kyc_dtl";
			String sqlQuery = String.format(
					"SELECT KYC_ID, DOC_UNIQUE_ID, DOCUMENT_TYPE, USER_OBJ FROM %s WHERE DOCUMENT_TYPE = ?1 AND USER_OBJ = ?2",
					tblNam);
			
			Query query = entityManager.createNativeQuery(sqlQuery);
			query.setParameter(1, docType);
			query.setParameter(2, user.getUserId());
			
			List<Object[]> dataList = query.getResultList();
			
			for(Object[] records : dataList) {
				log.info(records[0].toString());
				log.info(records[1].toString());
				log.info(records[2].toString());
				log.info(records[3].toString());
			}
			
		} catch (Exception e) {
			log.error("Exception Occured in getDocUniqueId Method in KycRepoCustomImpl : {}", e.getMessage());
		}
		return null;
	}

}
