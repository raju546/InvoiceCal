package com.cg.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.cg.bean.Invoice;

public class FrontEnd {
	
	Scanner sc;
	
	
	//Main menu
	public int mainMenu()
	{
		System.out.println("---------Invoice Calculation App---------");
		sc = new Scanner(System.in);
		System.out.println("Enter 1 to input the details  ");
		System.out.println("Enter 2 to see the invoice  ");
		System.out.println("Enter 3 to exit  ");
		System.out.print("Your Choice ? : ");
		return (sc.nextInt());
	}

	
	//Method to accept input from user
	public void inputDetailsFromUser(Invoice ivObj)
	{
		sc = new Scanner(System.in);
		
		System.out.print("\nPlease enter package Weight in KG : ");
		ivObj.setWeight(sc.nextInt());
		System.out.print("Please enter Distance in KM : ");
		ivObj.setDistance(sc.nextInt());
	}
	
	
	//Method that prints Invoice
	public void displayInvoice(ArrayList<?> invoice)
	{
		System.out.println();
		Iterator<?> it = invoice.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	
}
