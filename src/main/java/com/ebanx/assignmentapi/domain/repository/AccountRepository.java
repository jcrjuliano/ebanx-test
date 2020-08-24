package com.ebanx.assignmentapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebanx.assignmentapi.domain.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

	
}
