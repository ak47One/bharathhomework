package com.bank.app.repo.custom;

import com.bank.app.DTO.KycDTO;
import com.bank.app.model.Customer;

public interface KycRepoCustom {
	
	public KycDTO getDocIdByImpl(Customer user, String docType);

}
