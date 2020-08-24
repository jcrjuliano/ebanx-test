package com.ebanx.assignmentapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.assignmentapi.domain.repository.AccountRepository;

@RestController
@RequestMapping(value = "/reset")
public class Reset {
	
	@Autowired
	AccountRepository accounts;
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping
	public String reset() {
		accounts.deleteAll();
		return "OK";
	}
	
}
