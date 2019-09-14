package com.capgemini.service;

import com.capgemini.model.Customer;
import com.capgemini.model.Transactions;

public interface CustomerService {
	boolean AddCustomerAccount(Customer cust);
	Customer getCustomer(Long phn_num);
	double addAmount(double ammount,Customer cust);
	double withDrawAmount(double amount,Customer cust);
	double transcation(Customer present,Customer recepient,double amount);
	double getBalance(Customer c);
	Transactions getTransactions(Customer c);
}
