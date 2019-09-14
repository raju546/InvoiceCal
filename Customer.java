package com.capgemini.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paytm_customers")
public class Customer {
	@Id
	private long customer_phn_num;
	private String customer_name;
	private String customer_pswd;
	private double customer_Acc_bal;
	//private List<String> transcations = new ArrayList<String>();
	public Customer(){}
	public Customer(long customer_phn_num, String customer_name, String customer_pswd) {
		super();
		this.customer_phn_num = customer_phn_num;
		this.customer_name = customer_name;
		this.customer_pswd = customer_pswd;
		this.customer_Acc_bal = 0;
		//this.transcations.add("------------ Your Transcations -------------");
	}

	public long getCustomer_phn_num() {
		return customer_phn_num;
	}

	public void setCustomer_phn_num(long customer_phn_num) {
		this.customer_phn_num = customer_phn_num;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_pswd() {
		return customer_pswd;
	}

	public void setCustomer_pswd(String customer_pswd) {
		this.customer_pswd = customer_pswd;
	}

	public double getCustomer_Acc_bal() {
		return customer_Acc_bal;
	}

	public void setCustomer_Acc_bal(double customer_Acc_bal) {
		this.customer_Acc_bal = customer_Acc_bal;
	}
	
}
