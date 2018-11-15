package com.capgemini.AccountManagementSystem.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Transaction {
	@Id
	private Long TransactionNo;
	private Long AccountNo;
	private Double transferAmt;
	private Double balance;
		
	public Transaction() {
		
	}

	public Long getTransactionNo() {
		return TransactionNo;
	}

	public void setTransactionNo(Long transactionNo) {
		TransactionNo = transactionNo;
	}

	public Long getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(Long accountNo) {
		AccountNo = accountNo;
	}

	public Double getTransferAmt() {
		return transferAmt;
	}

	public void setTransferAmt(Double transferAmt) {
		this.transferAmt = transferAmt;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Transaction [TransactionNo=" + TransactionNo + ", AccountNo=" + AccountNo + ", transferAmt="
				+ transferAmt + ", balance=" + balance + "]";
	}
	
}