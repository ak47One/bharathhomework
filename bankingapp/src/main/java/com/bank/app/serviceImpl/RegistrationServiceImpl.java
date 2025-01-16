package com.bank.app.serviceImpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.DTO.NewCustomerRegisterationDTO;
import com.bank.app.model.AccountDetails;
import com.bank.app.model.Customer;
import com.bank.app.repo.AccountDetailsRepo;
import com.bank.app.repo.CustomerRepo;
import com.bank.app.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	private CustomerRepo cusRepo;

	@Autowired
	private AccountDetailsRepo accDetailsRepo;

	public String crateCustomerAndAccout(NewCustomerRegisterationDTO dto) {

		Customer customer = new Customer();
		customer.setCustmrFirstName(dto.getCustmrFirstName());
		customer.setCustmrLastName(dto.getCustmrLastName());
		customer.setCustmrEmailId(dto.getCustmrEmailId());
		customer.setCustmrPassword(dto.getCustmrPassword());
		customer.setPhoneNo(dto.getPhoneNo());

		Customer savedCus = cusRepo.save(customer);

		String accnum = gendrateAccountNum();

		AccountDetails accdetails = new AccountDetails();

		accdetails.setAccntNo(accnum);
		accdetails.setAccntBalance(dto.getAccntBalance() != null ? dto.getAccntBalance() : BigDecimal.ZERO);
		accdetails.setAccntType(dto.getAccntType());
		accdetails.setCustmrObj(savedCus);
		accDetailsRepo.save(accdetails);

		savedCus.setAccountDetails(accdetails);

		return accdetails.getAccntNo() ;
	}

//	 Customer saveCustomer = CustomerRepo.save(customer);
	private String gendrateAccountNum() {

		String accoutNoPrifix = "111772150000";

		Long lastId = accDetailsRepo.findMaxAccountId();

		Long newId = (lastId != null ? lastId + 1 : 1);
//	 return accoutNoPrifix +String.format("%04d", newId);

		return String.format("%s%04d", accoutNoPrifix, newId);

	}

}
