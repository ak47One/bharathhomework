package com.bank.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.app.DTO.KycDTO;
import com.bank.app.service.KycService;

@RestController
public class KycRestController {

	private static final Logger log = LogManager.getLogger(KycRestController.class);

	@Autowired
	private KycService kycService;

	@GetMapping("/updateKyc")
	public String updateKycInfo(@RequestBody KycDTO kycDTO) {
		boolean isIdValid = false;
		if (null != kycDTO) {
			String docUniqueId = kycDTO.getDocUniqueId();

			// checking if the given id is valid one or not
			switch (kycDTO.getDocType().toUpperCase()) {
			case "AADHAAR":
				isIdValid = docUniqueId.matches("\\d+") && docUniqueId.length() == 12;
				break;
			case "PANCARD", "VOTERID":
				isIdValid = docUniqueId.matches("^[A-Z0-9]+$") && docUniqueId.length() == 10;
				break;
			default:
				break;

			}
		}
		// Saving the Data if valid
		if (isIdValid)
			return kycService.updateKYCData(kycDTO);

		return "KYC ID is Invalid";
	}

	@GetMapping("/getKyc")
	public String getDocUniqueId(@RequestParam String typ, @RequestParam String usrId) {
		return kycService.getDocUniqueId(typ, usrId);
	}

}