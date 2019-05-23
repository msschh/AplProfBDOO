package com.apbdoo.lab8.dao;

import com.apbdoo.lab8.model.Customer;

import java.util.List;



public interface CustomerDAO {


	public List<Customer> getCustomers();
	public void saveCustomer(Customer customer);
}
