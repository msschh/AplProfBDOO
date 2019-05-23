package com.apbdoo.lab8.service;

import com.apbdoo.lab8.model.Customer;

import java.util.List;

public interface CustomerService {

	public List<Customer> getCustomers();
	public void saveCustomer(Customer customer);
	
}
