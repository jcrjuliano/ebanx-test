package com.ebanx.assignmentapi.api.model;

import com.ebanx.assignmentapi.api.model.enumerator.EventEnum;

public class EventModel {
	
	private EventEnum type;
	private Long origin;
	private Long amount;
	private Long destination;
	
	public EventModel(EventEnum type, Long origin, Long amount, Long destination) {
		this.type = type;
		this.origin = origin;
		this.amount = amount;
		this.destination = destination;
	}
	
	public EventEnum getType() {
		return type;
	}
	public void setType(EventEnum type) {
		this.type = type;
	}
	public Long getOrigin() {
		return origin;
	}
	public void setOrigin(Long origin) {
		this.origin = origin;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getDestination() {
		return destination;
	}
	public void setDestination(Long destination) {
		this.destination = destination;
	}
	
}
