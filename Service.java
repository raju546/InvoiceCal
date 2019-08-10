package com.cg.service;

import java.util.Random;
import java.util.Scanner;

import com.cg.bean.Invoice;
import com.cg.bean.InvoiceRepo;
import com.cg.bean.InvoiceService;
import com.cg.dao.DataStorage;
import com.cg.ui.FrontEnd;

public class Service implements InvoiceService, InvoiceRepo {
	
	Scanner sc;
	Invoice ivObj;
	FrontEnd feObj;
	DataStorage dsObj;
	
	public Service() {}
	
	public Service(FrontEnd feObj, Invoice ivObj, DataStorage dsObj)
	{
		this.ivObj = ivObj;
		this.feObj = feObj;
		this.dsObj = dsObj;
	}
	
	//This method drives the Application/ Controls the flow of application
	public void driverMethod()
	{
		sc = new Scanner(System.in);
		int choice = feObj.mainMenu();
		
		if(choice==1)
		{
			calculateInvoice(ivObj);
			saveInvoice(ivObj);
			System.out.println("\nDetails Saved Successfuly\n");
			driverMethod();
		}
		else if(choice==2)
		{
			sendInvoiceToFrontEnd();
			System.out.println("\nDo you want to continue ? : (Y/N)");
			if(sc.next().toLowerCase().equals("y"))
			{
				driverMethod();
			}
			else {
				System.exit(0);
			}
		}
		else if(choice==3)
		{
			System.out.println("Exiting App....");
			System.exit(0);
		}
		else {
			System.out.println("Invalid Choice, Please try again\n");
			driverMethod();
		}
		 
	}
	
	
	//This method is to Calculate Transportation Charges
	public double calculateTransportationCharges(int distance, int weight)
	{
		double transportationCharges = 0.0;
		transportationCharges = ((double)distance*2.0)*(double)(weight);
		return transportationCharges;
	}
	
	
	//This method is to Calculate CGST
	public double calculateCGST(double transportCharges)
	{
		double cgst = 0.0;
		cgst = (transportCharges*3.5)/100.0;
		return cgst;
	}
	
	
	//This method is to Calculate SGST
	public double calculateSGST(double transportCharges)
	{
		double sgst = 0.0;
		sgst = (transportCharges*3.5)/100.0;
		return sgst;
	}
	
	
	//This method generates random ID
	public int generateId()
	{
		int id;
		Random rand = new Random();
		id = (int)rand.nextInt(20);
		return id;
	}
	
	//This method calculates total amount by adding transportation charges, CGST and SGST
	public double calculateAmount()
	{
		return (ivObj.getTransportCharges()+ivObj.getCgst()+ivObj.getSgst());
	}
	
	
	//This method sends Invoice to front end to display records
	public void sendInvoiceToFrontEnd()
	{
		feObj.displayInvoice(dsObj.getDataFromContainer());
	}
	
	
	//Implementation of saveInvoice interface
	@Override
	public int saveInvoice(Invoice bean) {
		dsObj.storeDataIntoContainer(bean);
		return 0;
	}

	
	//Implementation of calculate invoice interface
	@Override
	public int calculateInvoice(Invoice bean) {
		feObj.inputDetailsFromUser(bean);
		ivObj.setTransportCharges(calculateTransportationCharges(ivObj.getDistance(),ivObj.getWeight()));
		ivObj.setCgst(calculateCGST(ivObj.getTransportCharges()));
		ivObj.setSgst(calculateSGST(ivObj.getTransportCharges()));
		ivObj.setId(generateId());
		ivObj.setAmount(calculateAmount());
		return 0;
	}
		
		
	
	
	
	
	

}
