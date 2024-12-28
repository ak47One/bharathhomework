package com.bank.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.app.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByUserId(Long userId);
	
	User findByEmailId(String emailId);
	
	@Query("SELECT usr.accntBalance FROM User usr WHERE usr.accntNum =?1")
	String findByAccntNum(String accntNum);
	
	@Query("SELECT usr FROM User usr ORDER BY usr.accntOpenDate DESC LIMIT 3")
	List<User> getLatestUser();
}
