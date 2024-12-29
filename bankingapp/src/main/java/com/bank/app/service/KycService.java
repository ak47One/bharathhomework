package com.bank.app.service;

import com.bank.app.DTO.KycDTO;

public interface KycService {
	
	public String updateKYCData(KycDTO kycDTO);
	
	public String getDocUniqueId(String typ, String usrId);


}
