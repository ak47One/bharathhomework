package com.bank.app.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KycDTO {
	
	private Long kycId;
	
	private String docType;
	
	private String docUniqueId;
	
	private String userId;

}
