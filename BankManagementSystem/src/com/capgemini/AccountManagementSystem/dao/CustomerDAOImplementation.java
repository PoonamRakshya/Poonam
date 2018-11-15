package com.capgemini.AccountManagementSystem.dao;

import java.util.List;




import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.capgemini.AccountManagementSystem.entity.Account;
import com.capgemini.AccountManagementSystem.entity.Transaction;
import com.capgemini.AccountManagementSystem.exception.BankManagementException;
import com.capgemini.AccountManagementSystem.utility.JPAUtil;

public class CustomerDAOImplementation implements ICustomerDAO {
	EntityManager entityManager = null;

	@Override
	public boolean addCustomer(Account account1) throws BankManagementException{
		boolean flag = false;
		try {
			entityManager = JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(account1);// add in table 
			entityManager.getTransaction().commit();//
			return flag;
		} catch (PersistenceException e) {
			throw new BankManagementException(e.getMessage());
		} 
		
	}

	@Override
	public Account displayAccount(Long accountNo) throws BankManagementException{
		Account account = null;
		try {
			entityManager = JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			account = entityManager.find(Account.class, accountNo);
			return account;
		} catch (PersistenceException e) {
			throw new BankManagementException(e.getMessage());
		} 
	}

	@Override
	public Transaction deposit(Long accountNo, Double depositAmount, Transaction transaction) throws BankManagementException{
		Account account = null;

		try {
			entityManager = JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			account = entityManager.find(Account.class, accountNo);
			if(depositAmount>0)
			{
			Double newBalance = account.getBalance() + depositAmount;
			account.setBalance(newBalance);
			transaction.setBalance(newBalance);

			entityManager.merge(account);
			entityManager.getTransaction().commit();

			Transaction transaction1 = addTransaction(transaction);

			return transaction1;
			}else
			{
				System.out.println("Enter correct amount");
			}
		} catch (PersistenceException e) {
			throw new BankManagementException(e.getMessage());
		}
		return transaction; 
	}

	@Override
	public Transaction withdraw(Long accountNo, Double withdrawAmount, Transaction transaction)
			throws BankManagementException{
		Account account = null;
		Transaction transaction1;
		try {
			entityManager = JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			account = entityManager.find(Account.class, accountNo);
			if (account.getBalance() - withdrawAmount > 500) {
				Double newBalance = account.getBalance() - withdrawAmount;
				account.setBalance(newBalance);
				transaction.setBalance(newBalance);
				entityManager.merge(account);
				entityManager.getTransaction().commit();

				transaction1 = addTransaction(transaction);

				return transaction1;
			} else {
				Transaction transaction2 = null;
				return transaction2;
			}
		} catch (PersistenceException e) {
			throw new BankManagementException(e.getMessage());
		} 
	}

	@Override
	public Transaction fundTransfer(Long AccountNo, Double transferAmt, Transaction transaction)
			throws BankManagementException{
		Account account, account1 = null;
		Transaction transaction1;
		try {
			entityManager = JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();

			account = entityManager.find(Account.class, AccountNo);
			if (account.getBalance() - transferAmt > 500) {
				Double newBalance = account.getBalance() - transferAmt;
				account.setBalance(newBalance);
				transaction.setBalance(newBalance);

				entityManager.merge(account);

				account1 = entityManager.find(Account.class, AccountNo);
				Double newBalance1 = account1.getBalance() + transferAmt;
				account1.setBalance(newBalance1);

				entityManager.merge(account1);
				entityManager.getTransaction().commit();

				transaction1 = addTransaction(transaction);

				return transaction1;
			} else {
				Transaction transaction2 = null;
				return transaction2;
			}
		} catch (PersistenceException e) {
			throw new BankManagementException(e.getMessage());
		} 
	}

	@Override
	public List<Transaction> printTransactions(Long accountNo) throws BankManagementException{
		EntityManager entityManager = JPAUtil.getEntityManager();
		String jql = "select table from Transaction table where table.AccountNo=:num";
		TypedQuery<Transaction> typedQuery = entityManager.createQuery(jql, Transaction.class);
		typedQuery.setParameter("num", accountNo);
		List<Transaction> transactionList = typedQuery.getResultList();
	    return transactionList;
	}

	@Override
	public Transaction addTransaction(Transaction transaction) throws BankManagementException{
		Transaction transaction1 = null;
		try {
			entityManager = JPAUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(transaction);
			entityManager.getTransaction().commit();
			transaction1 = transaction;
			return transaction1;
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new BankManagementException(e.getMessage());
		} 
		
	}
}