package com.bank.app.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.DTO.KycDTO;
import com.bank.app.model.KycDoc;
import com.bank.app.model.User;
import com.bank.app.repo.KycRepo;
import com.bank.app.repo.UserRepo;
import com.bank.app.service.KycService;

@Service
public class KycServiceImpl implements KycService {
	
	private static final Logger log = LogManager.getLogger(KycServiceImpl.class);

	@Autowired
	private KycRepo kycRepo;

	@Autowired
	private UserRepo userRepo;

	@Override
	public String updateKYCData(KycDTO kycDTO) {

		try {
			User user = userRepo.findByUserId(Long.parseLong(kycDTO.getUserId()));

			KycDoc kycDoc = new KycDoc();
			kycDoc.setDocumentType(kycDTO.getDocType().toUpperCase());
			kycDoc.setDocUniqueId(kycDTO.getDocUniqueId());
			kycDoc.setUserObj(user);
			
			kycRepo.save(kycDoc);
			
			return "KYC Saved Successfully";
		} catch (Exception e) {
			return "KYC Update Failed";
		}
	}

	@Override
	public String getDocUniqueId(String typ, String usrId) {
		try {
			User user = userRepo.findByUserId(Long.parseLong(usrId));
			KycDoc kycDoc = kycRepo.getDocUniqueId(user, typ);
			
			return kycDoc.getDocUniqueId();
			
		} catch (Exception e) {
			log.error("Exception occured in getDocUniqueId method in KycServiceImpl :{}", e.getMessage());
			return "Error occurred in getting Id";
		}
	}


}
