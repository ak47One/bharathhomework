package com.bank.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.app.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByUserId(Long userId);
	@Query("select ",)
	User findByEmailId(String emailId);
}
