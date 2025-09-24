package com.ofss.service;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ofss.model.Customer;

@Service
public class CustomerService {

	public ArrayList<Customer> allCustomers;

	public CustomerService() {
		// let's initialize some values
		allCustomers = new ArrayList<>();
		Customer c1 = new Customer(1, "Guru", "Murthy", 9731801675L, "guru@oracle.com");
		Customer c2 = new Customer(2, "Sachin", "Tendulkar", 9876789L, "sachin@oracle.com");
		Customer c3 = new Customer(3, "Vinochan", "K", 345678765L, "vinochan@oracle.com");
		Customer c4 = new Customer(4, "Swati", "Kokare", 23456754L, "sk@oracle.com");
		Customer c5 = new Customer(5, "darshan", "D", 678908L, "darshan@oracle.com");
		allCustomers.add(c1);
		allCustomers.add(c2);
		allCustomers.add(c3);
		allCustomers.add(c4);
		allCustomers.add(c5);
		System.out.println("CustomerService initialized with sample data");
	}

	public ResponseEntity<Object> getAllCustomers() {
		// simply return the arraylist
		System.out.println("getAllCustomers from CustomerService called");
		return ResponseEntity.status(HttpStatus.OK).body(allCustomers);
		// status code will be attached to response header
		// data is sent via Response body
	}

	public ResponseEntity<Object> getACustomerById(int custId) {
		System.out.println("getACustomerById from CustomerService called for id " + custId);
		for (Customer c : allCustomers) {
			if (c.getCustId() == custId) {
				return ResponseEntity.status(HttpStatus.OK).body(c); // success
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The custid is not present"); // returning null if there
																								// is no customer id
																								// present
	}

}
