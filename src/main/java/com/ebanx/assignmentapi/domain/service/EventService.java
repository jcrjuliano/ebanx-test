package com.ebanx.assignmentapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ebanx.assignmentapi.api.model.EventModel;

@Service
public class EventService {
	
	@Autowired
	AccountService accountService;
	
	public ResponseEntity<Object> proccessEvent(EventModel event) {
		switch (event.getType()) {
		case deposit:
			return accountService.deposit(event);
		case transfer:
			return accountService.transfer(event);
			
		case withdraw:
			return accountService.withdraw(event);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}

}
