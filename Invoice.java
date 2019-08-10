package com.cg.bean;

public class Invoice {
	
	
	private int id;
	private int weight;
	private int distance;
	private double transportCharges;
	private double cgst;
	private double sgst;
	private double amount;

	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		if(weight>1)
		this.weight = weight;
		else {
			throw new RuntimeException("Weight should be more than 1KG, Please retry");	
		}
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		if(distance>100)
		this.distance = distance;
		else {
			throw new RuntimeException("Distance should not be less than 100KM, Please retry");
			
		}
	}
	public double getTransportCharges() {
		return transportCharges;
	}
	public void setTransportCharges(double transportCharges) {
		this.transportCharges = transportCharges;
	}
	public double getCgst() {
		return cgst;
	}
	public void setCgst(double cgst) {
		this.cgst = cgst;
	}
	public double getSgst() {
		return sgst;
	}
	public void setSgst(double sgst) {
		this.sgst = sgst;
	}
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", weight=" + weight + ", distance=" + distance + ", transportCharges="
				+ transportCharges + ", cgst=" + cgst + ", sgst=" + sgst + ", amount=" + amount + "]";
	}
	
	

	

}
