package com.apbdoo.lab8.service;

import java.util.List;

import com.apbdoo.lab8.dao.CustomerDAO;
import com.apbdoo.lab8.model.Customer;
import com.apbdoo.lab8.model.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	Hello hello;

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {

		hello.getName();
		customerDAO.saveCustomer(customer);
	}
}





