package com.ebanx.assignmentapi.domain.service;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ebanx.assignmentapi.api.model.EventModel;
import com.ebanx.assignmentapi.domain.model.Account;
import com.ebanx.assignmentapi.domain.model.AccountDTO;
import com.ebanx.assignmentapi.domain.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public void save(Account account) {
		accountRepository.save(account);
	}
	
	
	public ResponseEntity<Object> deposit(EventModel event) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		Account account = new Account(event.getDestination(), event.getAmount());
		
		if(accountRepository.existsById(event.getDestination())){
			account = accountRepository.getOne(event.getDestination());
			account.deposit(event.getAmount());
		}
		
		save(account);
		
		AccountDTO returnAccount = new AccountDTO(account);
		
		result.put("destination", returnAccount);
		
		return new ResponseEntity<Object>(result, HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<Object> withdraw(EventModel event){
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		Account account = new Account(event.getOrigin(), event.getAmount());
		
		if(!(accountRepository.existsById(account.getId()))) {
			return new ResponseEntity<Object>(0L, HttpStatus.NOT_FOUND);
		}
		
		Account accFound = accountRepository.getOne(account.getId());
		
		
		if(accFound.withdraw(account.getBalance())) {
			accountRepository.save(accFound);
			
			AccountDTO returnAccount = new AccountDTO(accFound);
		
			result.put("origin", returnAccount);
			return new ResponseEntity<Object>(result, HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>(0L, HttpStatus.NOT_ACCEPTABLE);
	}

	@Transactional
	public ResponseEntity<Object> transfer(EventModel event) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		if(!(accountRepository.existsById(event.getOrigin()))) {
			return new ResponseEntity<Object>(0L, HttpStatus.NOT_FOUND);
		}
		
		Account originAccount = accountRepository.getOne(event.getOrigin());
		
		if(originAccount.withdraw(event.getAmount())) {
			deposit(event);
			
			AccountDTO returnOriginAccount = new AccountDTO(originAccount);
			AccountDTO returnDestinationAccount = new AccountDTO(accountRepository.getOne(event.getDestination()));
			
			result.put("origin", returnOriginAccount);
			result.put("destination", returnDestinationAccount);
			return new ResponseEntity<Object>(result, HttpStatus.CREATED); 
		}
				
		return new ResponseEntity<Object>(0L, HttpStatus.NOT_ACCEPTABLE);
	}
	

}

