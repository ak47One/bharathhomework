package com.bank.app.service;

import com.bank.app.DTO.KycDTO;

public interface KycService {
	
	public String updateKYCData(KycDTO kycDTO);	

	public String getKYCData(String typ, String usrId);


}
