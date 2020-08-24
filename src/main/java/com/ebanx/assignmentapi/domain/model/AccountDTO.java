package com.ebanx.assignmentapi.domain.model;

//I'm using this class as a DTO, only for converting the ID to String, as the test API requirement
public class AccountDTO {

	private String id;
	
	private Long balance;
	
	public AccountDTO(String id, Long balance) {
		this.id = id;
		this.balance = balance;
	}
	
	public AccountDTO(Account account) {
		this.id = account.getId().toString();
		this.balance = account.getBalance();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

}
