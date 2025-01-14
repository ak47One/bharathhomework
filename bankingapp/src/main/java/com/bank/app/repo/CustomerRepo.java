package com.bank.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.app.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

	Customer findByCustmrId(Long custmrId);

	Customer findByCustmrEmailId(String emailId);

	/*
	 * @Query("SELECT usr.accntBalance FROM User usr WHERE usr.accntNum =?1") String
	 * findByAccntNum(String accntNum);
	 */

	/*
	 * @Query("SELECT usr FROM User usr ORDER BY usr.accntOpenDate DESC LIMIT 3")
	 * List<User> getLatestUser();
	 */
	
	// order by ku space vidu da ,
	// select apurom usr podu,first order by short panna use pannu
	// desc and aesc use karo
	// from and where spelling
	// retun type singl ah irutha user ithuve more than one na user List<User> ithu
	// method starting laye yosi

	/*
	 * @Query("SELECT SUM(usr.accntBalance) FROM User usr") String getBankBalance();
	 */
	
	// ellarthukum usr or obj podanu its not sql querry
	//it maps by entity jpa qurreyis different
	//save the file illana erro varu
	
}
