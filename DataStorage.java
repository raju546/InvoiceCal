package com.cg.dao;

import java.util.ArrayList;

import com.cg.bean.Invoice;

public class DataStorage {
	
	//The container to store the Details
	ArrayList<Object> dataContainer;
	
	
	//Default Constructor
	public DataStorage() {}
	
	
	//Method that stores details into Container(ArrayList)
	public void storeDataIntoContainer(Invoice bean)
	{
		dataContainer = new ArrayList<>();
		
		dataContainer.add("Product ID : "+bean.getId());
		dataContainer.add("Product Weight : "+bean.getWeight());
		dataContainer.add("Total Distance : "+bean.getDistance());
		dataContainer.add("Transport Charges : "+bean.getTransportCharges());
		dataContainer.add("CGST : "+bean.getCgst());
		dataContainer.add("SGST : "+bean.getSgst());
		dataContainer.add("Total Amount : "+bean.getAmount());
			
	}

	
	//Returns the data container
	public ArrayList<Object> getDataFromContainer()
	{
		return dataContainer;
	}
	
}
