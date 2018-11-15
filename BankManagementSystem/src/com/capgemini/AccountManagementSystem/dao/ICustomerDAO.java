package com.capgemini.AccountManagementSystem.dao;

import java.util.List;

import com.capgemini.AccountManagementSystem.entity.Account;
import com.capgemini.AccountManagementSystem.entity.Transaction;
import com.capgemini.AccountManagementSystem.exception.BankManagementException;

public interface ICustomerDAO {
	public boolean addCustomer(Account a) throws BankManagementException ;
	public Account displayAccount(Long accountNo) throws BankManagementException ;
	public Transaction deposit(Long accountNo, Double depositAmount, Transaction transaction) throws BankManagementException ;
	public Transaction withdraw(Long accountNo , Double withdrawAmount, Transaction transaction) throws BankManagementException; 
	public List<Transaction> printTransactions(Long accountNo)throws  BankManagementException;
	public Transaction addTransaction(Transaction transaction) throws BankManagementException;
	Transaction fundTransfer(Long AccountNo, Double transferAmt, Transaction transaction) throws BankManagementException;
}