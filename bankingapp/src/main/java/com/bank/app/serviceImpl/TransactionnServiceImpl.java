package com.bank.app.serviceImpl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.DTO.TransactionDTO;
import com.bank.app.model.AccountDetails;
import com.bank.app.model.Transaction;
import com.bank.app.repo.AccountDetailsRepo;
import com.bank.app.repo.TransactionnRepo;
import com.bank.app.service.TransactionnService;
import com.bank.app.utility.PaymentType;
import com.bank.app.utility.TransactionStatus;

import jakarta.transaction.Transactional;

@Service
public class TransactionnServiceImpl implements TransactionnService {

	@Autowired
	private AccountDetailsRepo accountRepo;

	@Autowired
	private TransactionnRepo transRepo;

	private final ConcurrentHashMap<String, Boolean> refIdSet = new ConcurrentHashMap<>();
	private final AtomicInteger dailyCounter = new AtomicInteger(0);

	@Transactional

	public String createTransaction(TransactionDTO tDTO) {

		Transaction trans = new Transaction();

		trans.setPayeeName(tDTO.getPayeeName());
		trans.setPayeeAccntNo(tDTO.getPayeeAccNo());
		trans.setPayerName(tDTO.getPayerName() != null ? tDTO.getPayerName() : "");
		trans.setPayerAccntNo(tDTO.getPayerAccntNo() != null ? tDTO.getPayerAccntNo() : "");
		trans.setTransDate(new Date());
		trans.setModeOfPayment(tDTO.getModeOfPayment());
		trans.setTransAmount(tDTO.getTransAmount());
		trans.setTransType(tDTO.getTransType());
		trans.setTransReferId(generateUniqueReferenceId());
		trans.setTransStatus(TransactionStatus.PENDING.name());

//		if(tDTO.getTransType().equalsIgnoreCase("DD")||tDTO.getTransType().equalsIgnoreCase("CASH")) {
//			trans.setTransStatus("Success");
//			transRepo.save(trans);
//			return "Transaction is " +trans.getTransStatus();
//		}

		AccountDetails payeeAccnt = accountRepo.findByAccntNo(tDTO.getPayeeAccNo());

		trans.setCustmrObj(payeeAccnt.getCustmrObj());

		if (isNonAccountPayment(tDTO.getModeOfPayment())) {
			trans.setTransStatus(TransactionStatus.SUCCESS.name());
			transRepo.save(trans);
			return "Transaction is " + TransactionStatus.SUCCESS.name();
		}

		AccountDetails payerAccnt = accountRepo.findByAccntNo(tDTO.getPayerAccntNo());
		if (payerAccnt == null) {
			throw new RuntimeException("Payer account not founr");
		}
		BigDecimal avaliableBal = payerAccnt.getAccntBalance();

		BigDecimal transAmount = trans.getTransAmount();

		if (avaliableBal.compareTo(transAmount) < 0) {
			trans.setTransStatus("Failed");
			throw new RuntimeException("insufficent Fund");
		}

		try {
			payerAccnt.setAccntBalance(avaliableBal.subtract(transAmount));
			payeeAccnt.setAccntBalance(payeeAccnt.getAccntBalance().add(transAmount));
			accountRepo.save(payerAccnt);
			accountRepo.save(payeeAccnt);
			
			
			transRepo.save(trans);
			trans.setTransStatus(TransactionStatus.SUCCESS.name());
			return " transaction is" + trans.getTransStatus();
		} catch (Exception e) {
			trans.setTransStatus(TransactionStatus.FAILED.name());
			throw new RuntimeException("Transaction faild" + e.getMessage());
		}

	}

	private boolean isNonAccountPayment(String modeOfPayment) {

		return PaymentType.CASH.name().equalsIgnoreCase(modeOfPayment)
				|| PaymentType.CHEQUE.name().equalsIgnoreCase(modeOfPayment);

	}

	private String generateUniqueReferenceId() {
		String uniqueId;
		String datePart = new SimpleDateFormat("yyyyMMdd").format(new Date());
		int serialNum;

		do {
			serialNum = dailyCounter.incrementAndGet();
			uniqueId = String.format("BharathBnk-%s-%05d", datePart, serialNum);
		} while (refIdSet.putIfAbsent(uniqueId, true) != null);

		return uniqueId;
	}
	
	

}
