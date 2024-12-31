package com.bank.app.repo.custom;

import com.bank.app.DTO.KycDTO;
import com.bank.app.model.User;

public interface KycRepoCustom {
	
	public KycDTO getDocIdByImpl(User user, String docType);

}
