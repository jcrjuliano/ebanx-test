package com.ebanx.assignmentapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.assignmentapi.api.model.EventModel;
import com.ebanx.assignmentapi.domain.service.EventService;


@RestController
@RequestMapping("event")
public class Event {
	
	@Autowired
	EventService eventService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> deposit(@RequestBody EventModel event){
		
		return eventService.proccessEvent(event);
		//return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}

	 
	
}
