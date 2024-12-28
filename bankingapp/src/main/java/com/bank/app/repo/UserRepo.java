package com.bank.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.app.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	User findByUserId(Long userId);

	User findByEmailId(String emailId);
	
}
