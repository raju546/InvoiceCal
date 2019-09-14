package com.capgemini.dao;

import com.capgemini.model.Customer;
import com.capgemini.model.Transactions;

public interface CustomerDao {
	public boolean createCustomerAccount(Customer cust);
	public Customer getCustomer(Long phn_no);
	public double addAmount(double amount,Customer cust);
	public double withDraw(double amount,Customer cust);
	double transcations(Customer user,Customer recepient, double amount);
	public abstract void commitTransaction();
	public abstract void beginTransaction();
	public double getBalance(Customer c);
	public Transactions readAllTransactions(Customer c);
}
