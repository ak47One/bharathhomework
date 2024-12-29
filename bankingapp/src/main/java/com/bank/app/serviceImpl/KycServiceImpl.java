package com.bank.app.serviceImpl;

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

	@Autowired
	private KycRepo kycRepo;

	@Autowired
	private UserRepo userRepo;

	@Override
	public String updateKYCData(KycDTO kycDTO) {

		try {
			User user = userRepo.findByUserId(Long.parseLong(kycDTO.getUserId()));

			KycDoc kycDoc = new KycDoc();
			kycDoc.setDocumentType(kycDTO.getDocType());
			kycDoc.setDocUniqueId(kycDTO.getDocUniqueId());
			kycDoc.setUserObj(user);

			kycRepo.save(kycDoc);
		} catch (Exception e) {
			return "KYC Update Failed";
		}
		return "KYC Saved Successfully";
	}


}
