package com.capgemini.service;

import org.springframework.stereotype.Service;

import com.capgemini.dao.CustomerDao;
import com.capgemini.dao.CustomerDaoImpl;
import com.capgemini.model.Customer;
import com.capgemini.model.Transactions;
@Service

public class CustomerServiceImpl implements CustomerService{
	CustomerDao dao = new CustomerDaoImpl();
	@Override
	public boolean AddCustomerAccount(Customer cust) {
		dao.beginTransaction();
		dao.createCustomerAccount(cust);
		dao.commitTransaction();
		return true;
	}
	@Override
	public Customer getCustomer(Long phn_num) {
		dao.beginTransaction();
		Customer cust = dao.getCustomer(phn_num);
		dao.commitTransaction();
		return cust;
	}
	@Override
	public double addAmount(double amount, Customer cust) {
		dao.beginTransaction();
		double updatedamount = dao.addAmount(amount, cust);
		dao.commitTransaction();
		return updatedamount;
	}
	@Override
	public double withDrawAmount(double amount, Customer cust) {
		dao.beginTransaction();
		double updatedAmmount= dao.withDraw(amount, cust);
		dao.commitTransaction();
		return updatedAmmount;
	}
	@Override
	public double transcation(Customer present, Customer recepient, double amount) {
		dao.beginTransaction();
		double updatedAmmount = dao.transcations(present, recepient, amount);
		dao.commitTransaction();
		return updatedAmmount;
		
	}
	@Override
	public double getBalance(Customer c) {
		return dao.getBalance(c);
	}
	@Override
	public Transactions getTransactions(Customer c) {
		dao.beginTransaction();
		Transactions trans = dao.readAllTransactions(c);
		dao.commitTransaction();
		return trans;
	}

}
