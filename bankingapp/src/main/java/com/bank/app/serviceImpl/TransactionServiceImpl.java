package com.bank.app.serviceImpl;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.bank.app.DTO.TransactionDTO;
import com.bank.app.model.Transaction;
import com.bank.app.model.User;
import com.bank.app.repo.UserRepo;
import com.bank.app.service.TransactionService;
import com.bank.app.utility.TransType;

public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	public UserRepo userRepo;

	@Override
	public String updtAccntBalance(TransactionDTO transDTO) {
		
		User user = userRepo.findByUserId(Long.parseLong(transDTO.getPayerId()));
		
		Transaction trans = new Transaction();
		
		if(transDTO.getTransType().equalsIgnoreCase(TransType.WITHDRAWAL.name())) {
			if(user.getAccntBalance().compareTo(transDTO.getTransAmount()) >= 0) {
				trans.setUserObject(user);
				trans.setTransAmount(transDTO.getTransAmount());
				trans.setTransDate(new Date());
				trans.setPaymentType(transDTO.getPaymentType());
				trans.setTransReferId(String.format("TXN%s", generateRefId()));
				trans.setTransType(transDTO.getTransType());
				//trans.setTransStatus(transDTO.g);
				trans.setPayeeName(transDTO.getPayeeName());
				trans.setPayeeAccntNo(transDTO.getPayeeAccntNo());
				
				
				
			}
			
			
		}
		return null;
		
	}
	
	private Long generateReferenceId() {
		Random random = new Random();

        // Generate a random 12-digit number
        long min = 100_000_000_000L;  // 12-digit minimum value
        long max = 999_999_999_999L; // 12-digit maximum value

        // Generate random long between min and max (inclusive)
        Long random12DigitNumber = (Long)( min + (long) (random.nextDouble() * (max - min)));
        return random12DigitNumber;
	}
	
	private String generateRefId() {
		StringBuilder refId = new StringBuilder();
		Random random = new Random();
		
		// Ensure the first digit is not zero for a valid 12-digit number
		refId.append(random.nextInt(9) + 1); // Random digit between 1 and 9 for the first digit
		
		// Generate the next 11 digits (between 0 and 9)
		while(refId.length() < 12) {
			refId.append(random.nextInt(10));// Random digit between 0 and 9
		}
		return refId.toString();
	}

}
