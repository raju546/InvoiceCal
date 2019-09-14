package com.capgemini.controller;

import java.util.List;

import org.hibernate.SessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Customer;
import com.capgemini.service.CustomerService;


@RestController
@RequestMapping(value="minipaytm")
@CrossOrigin(origins = "http://localhost:4200")
public class MiniPaytmController {
	
	@Autowired
	private CustomerService service;
	
	@RequestMapping(path="/",method=RequestMethod.POST)
	public void addCustomer(@RequestBody Customer c){
		service.AddCustomerAccount(c);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Customer getCustomerById(@PathVariable("id")long phnnum){
		return service.getCustomer(phnnum);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public Customer login(@RequestBody Customer c){
		Customer present= service.getCustomer(c.getCustomer_phn_num());
		if(present == null)
			return null;
		if(present.getCustomer_phn_num() == c.getCustomer_phn_num() && present.getCustomer_pswd().equals(c.getCustomer_pswd()))
			return present;
		return null;
	}
	
	@RequestMapping(value="/deposit/{amount}", method=RequestMethod.POST)
	public void deposit(@PathVariable("amount") double amount){
		/*Customer c = new Customer();
		c.setCustomer_phn_num(7661036834L);
		return service.addAmount(amount, c);
		*/
	}
	
}
