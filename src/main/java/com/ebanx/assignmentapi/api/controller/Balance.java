package com.ebanx.assignmentapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.assignmentapi.domain.repository.AccountRepository;

@RestController
@RequestMapping("/balance")
public class Balance {
	
	@Autowired
	AccountRepository accounts;
	
	@GetMapping
	public ResponseEntity<Long> getBalance(@RequestParam("account_id") Long id){
		
		if(accounts.existsById(id)) {
				return new ResponseEntity<>(accounts.getOne(id).getBalance(), HttpStatus.OK);
		}
		return new ResponseEntity<>(0L, HttpStatus.NOT_FOUND);
	}

}
