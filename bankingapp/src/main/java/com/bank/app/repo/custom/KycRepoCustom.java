package com.bank.app.repo.custom;

import com.bank.app.model.KycDoc;
import com.bank.app.model.User;

public interface KycRepoCustom {
	
	public KycDoc getDocUniqueId(User user, String docType);

}
