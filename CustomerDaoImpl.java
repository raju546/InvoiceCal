package com.capgemini.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.model.Customer;
import com.capgemini.model.Transactions;
import com.capgemini.dao.JPAUtil;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	List<Customer> list = new ArrayList<Customer>();
	private EntityManager entityManager;
	String endline ="";
	public CustomerDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}
	@Override
	public boolean createCustomerAccount(Customer cust) {
		entityManager.persist(cust);
		return true;
	}
	@Override
	public Customer getCustomer(Long phn_no) {
		return entityManager.find(Customer.class, phn_no);
	}
	@Override
	public double addAmount(double amount, Customer customer) {
		Customer cust =entityManager.find(Customer.class, customer.getCustomer_phn_num());
		cust.setCustomer_Acc_bal((cust.getCustomer_Acc_bal()+amount));
		entityManager.merge(cust);
		cust =entityManager.find(Customer.class, customer.getCustomer_phn_num());
		Transactions transactions = new Transactions();
		transactions.setCustomerPhoneNum(customer.getCustomer_phn_num());
		String msg = "Credited "+amount;
		transactions.setTranscationDesc(msg);
		entityManager.persist(transactions);
		return cust.getCustomer_Acc_bal();
	}
	@Override
	public double withDraw(double amount, Customer cust) {
		Customer customer =entityManager.find(Customer.class, cust.getCustomer_phn_num());
		cust.setCustomer_Acc_bal((cust.getCustomer_Acc_bal()-amount));
		entityManager.merge(cust);
		customer =entityManager.find(Customer.class, customer.getCustomer_phn_num());
		Transactions transactions = new Transactions();
		transactions.setCustomerPhoneNum(cust.getCustomer_phn_num());
		String msg = "Debited "+amount;
		transactions.setTranscationDesc(msg);
		entityManager.persist(transactions);
		return customer.getCustomer_Acc_bal();
	}
	@Override
	public double transcations(Customer user, Customer recepient, double amount) {
		Customer CustomerUser = entityManager.find(Customer.class, user.getCustomer_phn_num());
		Customer CustomerRecepient = entityManager.find(Customer.class, recepient.getCustomer_phn_num());
		CustomerUser.setCustomer_Acc_bal((CustomerUser.getCustomer_Acc_bal()-amount));
		CustomerRecepient.setCustomer_Acc_bal((CustomerRecepient.getCustomer_Acc_bal()+amount));
		entityManager.merge(CustomerUser);
		entityManager.merge(CustomerRecepient);
		CustomerUser = entityManager.find(Customer.class, user.getCustomer_phn_num());
		return CustomerUser.getCustomer_Acc_bal();
	}
		
	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}
	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}
	@Override
	public double getBalance(Customer c) {
		Customer customer =entityManager.find(Customer.class, c.getCustomer_phn_num());
		return customer.getCustomer_Acc_bal();
	}
	@Override
	public Transactions readAllTransactions(Customer c) {
		return null;
	}
}
