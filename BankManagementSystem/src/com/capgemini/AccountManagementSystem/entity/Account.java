package com.capgemini.AccountManagementSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Id

	private Long accountNumber;
	private String cname;
	private Integer age;
	private String address;
	private Double balance;
	private String phoneNo;
	private String emailId;

	public Account() {
		super();
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNo) {
		this.accountNumber = accountNo;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", cname=" + cname + ", age=" + age + ", address=" + address
				+ ", balance=" + balance + ", phoneNo=" + phoneNo + ", emailId=" + emailId + "]";
	}

}