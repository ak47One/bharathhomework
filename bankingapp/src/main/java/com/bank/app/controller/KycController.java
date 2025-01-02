package com.bank.app.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bank.app.DTO.KycDTO;
import com.bank.app.service.KycService;

@Controller
public class KycController {
	
	private static final Logger log = LogManager.getLogger(KycController.class);
	
	@Autowired
	private KycService kycService;

	@GetMapping("/addKycDocument")
	public String addKycDocument(ModelMap map) {
		KycDTO kycDTO = new KycDTO();
		List<String> docTypeList = List.of("AADHHAR", "PANCARD", "VOTERID");
		map.addAttribute("docTypeList", docTypeList);
		map.addAttribute("kycDTO", kycDTO);
		return "kyc-data";
	}

	@PostMapping("/addKycDocument")
	public String addKycDocument(@ModelAttribute KycDTO kycDTO, Model model) {
		try {
		if (kycDTO != null) {
			boolean isKycValid = validateKycDetails(kycDTO);
			if (isKycValid)
				kycService.updateKYCData(kycDTO);
			model.addAttribute("message", "KYC Details Updated Successfully !!!");
		}
		} catch(Exception e) {
			log.error("Exception occured in Post - addKycDocument method in KycController : {}", e.getMessage());
		}
		return "kyc-result";
	}

	private boolean validateKycDetails(KycDTO kycDTO) {
		boolean isIdValid = false;
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
		return isIdValid;
	}
}
