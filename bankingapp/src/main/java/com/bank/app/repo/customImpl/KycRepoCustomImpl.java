package com.bank.app.repo.customImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bank.app.DTO.KycDTO;
import com.bank.app.model.KycDoc;
import com.bank.app.model.User;
import com.bank.app.repo.custom.KycRepoCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class KycRepoCustomImpl implements KycRepoCustom {

	private static final Logger log = LogManager.getLogger(KycRepoCustomImpl.class);

	@PersistenceContext
	EntityManager entityManager;

	public KycRepoCustomImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public KycDTO getDocIdByImpl(User user, String docType) {
		KycDTO kycDTO = new KycDTO();
		try {
			getDocIdByTypeQuery(docType, user);

			String tblNam = "kyc_dtl";
			String sqlQuery = String.format(
					"SELECT KYC_ID, DOC_UNIQUE_ID, DOCUMENT_TYPE, USER_OBJ FROM %s WHERE DOCUMENT_TYPE = ?1 AND USER_OBJ = ?2",
					tblNam);

			Query query = entityManager.createNativeQuery(sqlQuery);
			query.setParameter(1, docType);
			query.setParameter(2, user.getUserId());

			List<Object[]> dataList = query.getResultList();

			for (Object[] records : dataList) {

				log.info((Integer) records[0]);
				kycDTO.setKycId((Long) records[0]);

				log.info(records[1].toString());
				kycDTO.setDocType(records[1].toString());

				log.info(records[2].toString());
				kycDTO.setDocUniqueId(records[2].toString());

				log.info(records[3].toString());
				kycDTO.setUserId(records[3].toString());

			}

			return kycDTO;

		} catch (Exception e) {
			log.error("Exception Occured in getDocUniqueId Method in KycRepoCustomImpl : {}", e.getMessage());
		}
		return kycDTO;
	}

	private List<KycDoc> getDocIdByTypeQuery(String docType, User user) {
		try {

			String sqlQuery = "SELECT k FROM KycDoc k WHERE k.documentType =?1 AND k.userObj =?2";

			TypedQuery<KycDoc> query = entityManager.createQuery(sqlQuery, KycDoc.class);
			query.setParameter(1, docType);
			query.setParameter(2, user);

			List<KycDoc> docList = query.getResultList();

			return docList;

		} catch (Exception e) {
			log.error("Exception occured in getDocIdByTypeQuery method in KycRepoCustomImpl : {}", e.getMessage());
		}
		return null;
	}

}
