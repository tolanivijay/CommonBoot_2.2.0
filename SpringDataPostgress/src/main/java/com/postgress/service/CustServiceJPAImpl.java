package com.postgress.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgress.Customer;
import com.postgress.CustomerRepository;

@Service("custServiceJPA")
public class CustServiceJPAImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	
	public void bulkcreate() {
		repository.save(new Customer("Rajesh", "Bhojwani"));

		// save a list of Customers
		repository.saveAll(Arrays.asList(new Customer("Salim", "Khan"), new Customer("Rajesh", "Parihar"),
				new Customer("Rahul", "Dravid"), new Customer("Dharmendra", "Bhojwani")));
	}

	public List<Customer> findAll() {

		return repository.findAll();
	}

	
	@Override
	public List<Customer> findByFirstName(String first) {
		return repository.findByFirstName(first);
	}



}
