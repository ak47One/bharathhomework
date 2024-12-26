package com.BankUser.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BankUser.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
