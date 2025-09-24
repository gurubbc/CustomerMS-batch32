package com.ofss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public ResponseEntity<Object> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@RequestMapping(value="/customers/id/{customerId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getAllCustomers(@PathVariable("customerId") int cid) {
		return customerService.getACustomerById(cid);
	}

	
}
