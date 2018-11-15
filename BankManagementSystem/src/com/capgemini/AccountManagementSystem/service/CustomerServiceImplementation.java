package com.capgemini.AccountManagementSystem.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.AccountManagementSystem.dao.CustomerDAOImplementation;
import com.capgemini.AccountManagementSystem.entity.Account;
import com.capgemini.AccountManagementSystem.entity.Transaction;
import com.capgemini.AccountManagementSystem.exception.BankManagementException;

public class CustomerServiceImplementation implements ICustomerService {
	CustomerDAOImplementation dao = new CustomerDAOImplementation();

	// To validate name:
	public boolean validateName(String name) throws BankManagementException {
		boolean flag = false;
		Pattern Name = Pattern.compile("[A-Za-z]+\\.?");
		Matcher Namematch = Name.matcher(name);
		if (Namematch.matches() && name.length() > 2) {
			flag = true;
		} else {
			System.err.println("Enter the NAME correctly");
		}
		return flag;
	}

	// To validate email:
	public boolean isValidateEmail(String email) throws BankManagementException {
		String Pattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(Pattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	// To validate phone number:
	public boolean validateNumber(String mobile)

	{
		boolean flag = false;
		Pattern Mobile = Pattern.compile("[6-9][0-9]{9}");
		Matcher Mobilematcher = Mobile.matcher(mobile);
		if (Mobilematcher.matches()) {
			flag = true;
		} else {
			System.err.println("\n Enter the number correctly");
		}
		return flag;
	}

	// To validate age:
	public boolean validateAge(int age) throws BankManagementException {
		if (age > 16 && age < 100)
			return true;
		else
			System.err.println("Enter valid age");
		return false;
	}
	
	//To validate account balance:
	public boolean validateBalance(double balance) throws BankManagementException {
		if (balance >= 1000)
			return true;
		else
			System.err.println("Enter a valid balance..(should be more than Rs.1000)");
		return false;
	}

	@Override
	public boolean addCustomer(Account account) throws BankManagementException {
		return dao.addCustomer(account);
	}

	@Override
	public Account displayAccount(Long accountNo) throws BankManagementException {
		return dao.displayAccount(accountNo);
	}

	@Override
	public Transaction deposit(Long accountNo, Double depositAmount, Transaction transaction)
			throws BankManagementException {
		return dao.deposit(accountNo, depositAmount, transaction);
	}

	@Override
	public Transaction withdraw(Long accountNo, Double withdrawAmount, Transaction transaction)
			throws BankManagementException {
		return dao.withdraw(accountNo, withdrawAmount, transaction);
	}

	@Override
	public Transaction fundTransfer(Long AccountNo, Double transferAmt, Transaction transaction)
			throws BankManagementException {
		return dao.fundTransfer(AccountNo, transferAmt, transaction);
	}

	@Override
	public List<Transaction> printTransactions(Long accountNo) throws BankManagementException {
		return dao.printTransactions(accountNo);
	}

}