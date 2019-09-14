package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TransactionsJPA")
public class Transactions {
	@SequenceGenerator(name="seq", initialValue=1000, allocationSize=100000)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	private int transcationId;
	@Id
	private long customerPhoneNum;
	private String transcationDesc;
	public Transactions(){
		
	}
	public int getTranscationId() {
		return transcationId;
	}
	public void setTranscationId(int transcationId) {
		this.transcationId = transcationId;
	}
	
	public long getCustomerPhoneNum() {
		return customerPhoneNum;
	}
	public void setCustomerPhoneNum(long customerPhoneNum) {
		this.customerPhoneNum = customerPhoneNum;
	}
	public String getTranscationDesc() {
		return transcationDesc;
	}
	public void setTranscationDesc(String transcationDesc) {
		this.transcationDesc = transcationDesc;
	}
	
}
