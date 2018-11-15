package com.capgemini.AccountManagementSystem.presentation;

import java.io.IOException;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.capgemini.AccountManagementSystem.entity.Account;
import com.capgemini.AccountManagementSystem.entity.Transaction;
import com.capgemini.AccountManagementSystem.exception.BankManagementException;
import com.capgemini.AccountManagementSystem.service.CustomerServiceImplementation;

public class Client {
	public static void main(String[] args) throws IOException, BankManagementException{

		while (true) {

			System.out.println("Hi, Welcome to AXIS Bank\n\n");

			System.out.println("1. Create Account");
			System.out.println("2. Show Balance");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Fund Transfer");
			System.out.println("6. Print Transaction");
			System.out.println("7. Exit");

			System.out.println("Enter your choice:");
			CustomerServiceImplementation service = new CustomerServiceImplementation();
			Scanner sc = new Scanner(System.in);
			int Ch = sc.nextInt();

			switch (Ch) {
			case 1:
				Account ac = new Account();
				String name, email, mobile;
				int age;
				double balance;
				long a;

				do {
					System.out.println("Enter your Name");
					name = sc.next();
				} while (!service.validateName(name));
				ac.setCname(name);

				do {
					System.out.println("Enter your email id");
					email = sc.next();
				} while (!service.isValidateEmail(email));
				ac.setEmailId(email);

				do {
					System.out.println("Enter your age");
					age = sc.nextInt();
				} while (!service.validateAge(age));
				ac.setAge(age);

				do {
					System.out.println("Enter your Phone number");
					mobile = sc.next();
				} while (!service.validateNumber(mobile));
				ac.setPhoneNo(mobile);

				System.out.println("Enter your Address");
				String address = sc.next();
				ac.setAddress(address);

				Random rand = new Random();
				Integer accNum = 1000000 + rand.nextInt(9000000);
				Long accountNo = (long) accNum;
				System.out.println(accountNo);
				ac.setAccountNumber(accountNo);

				do {
					System.out.println("Enter initial balance");
					balance = sc.nextInt();
				} while (!service.validateBalance(balance));
				ac.setBalance(balance);

				a = ac.getAccountNumber();
				boolean add = service.addCustomer(ac);
				System.out.println(ac);
				System.out.println("Your Account Number is:" + a);
				break;

			case 2:
				System.out.println("Enter Account number to view the balance");
				System.out.println("enter account number");
				Long accountNo2 = sc.nextLong();

				Account c = service.displayAccount(accountNo2);
				System.out.println(c.getAccountNumber() + " has a balance of Rs." + c.getBalance());

				break;

			case 3:
				Transaction transaction3 = new Transaction();

				System.out.println("Enter Account Number");
				Long accountNo3 = sc.nextLong();

				System.out.println("Enter the amount to deposit");
				Double depositAmount = sc.nextDouble();

				Random rand1 = new Random();
				Integer trans = 1000000 + rand1.nextInt(9000000);
				Long TransactionNo = (long) trans;
				transaction3.setTransactionNo(TransactionNo);

				transaction3.setAccountNo(accountNo3);

				transaction3.setTransferAmt(depositAmount);

				Transaction depositTransaction = service.deposit(accountNo3, depositAmount, transaction3);
				System.out.println("Transactions made are:" + depositTransaction);

				break;

			case 4:
				Transaction transaction4 = new Transaction();
				System.out.println("Enter Account Number and Amount to Withdraw");

				System.out.println("Enter your Account Number");
				Long accountNo4 = sc.nextLong();

				System.out.println("Enter the amount to Withdraw");
				Double withdrawAmount = sc.nextDouble();

				Random rand2 = new Random();
				Integer trans1 = 1000000 + rand2.nextInt(9000000);
				Long TransactionNo1 = (long) trans1;
				transaction4.setTransactionNo(TransactionNo1);

				transaction4.setTransferAmt(withdrawAmount);

				Transaction withdrawTrans = service.withdraw(accountNo4, withdrawAmount, transaction4);
				System.out.println("Transaction made are:" + withdrawTrans);
				break;

			case 5:
				Transaction transaction5 = new Transaction();

				System.out.println("Enter your Account Number");
				Long accountNo5 = sc.nextLong();

				System.out.println("Enter the amount to Transfer");
				Double transferAmount = sc.nextDouble();

				Random rand3 = new Random();
				Integer trans2 = 1000000 + rand3.nextInt(9000000);
				Long TransactionNo2 = (long) trans2;
				transaction5.setTransactionNo(TransactionNo2);

				transaction5.setAccountNo(accountNo5);


				transaction5.setTransferAmt(transferAmount);

				Transaction transferTransaction = service.fundTransfer( accountNo5, transferAmount,	transaction5);
				System.out.println("Transaction Details are:" + transferTransaction);
				break;

			case 6:
				System.out.println("Enter your Account Number to view your Transactions");

				System.out.println("enter your account number");
				Long accountNo6 = sc.nextLong();
				List<Transaction> transactionList = service.printTransactions(accountNo6);
				Iterator<Transaction> iterator = transactionList.iterator();
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
				}
				break;

			case 7:
				System.out.println("Thank You for using Axis Bank.\n");
				System.out.println("Please Come Again..");
				sc.close();
				System.exit(0);
				break;
			default:
				break;
			}

		}

	}

}