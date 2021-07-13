package com.postgress.service;

import java.util.List;

import com.postgress.Customer;

public interface CustomerService {
	
	public List<Customer> findAll();
	
	public List<Customer> findByFirstName(String first);
	
	public void bulkcreate();

}
