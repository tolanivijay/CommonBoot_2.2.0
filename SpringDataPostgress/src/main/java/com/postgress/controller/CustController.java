package com.postgress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.postgress.Customer;
import com.postgress.service.CustomerService;

@RestController
public class CustController {

	@Autowired
	@Qualifier("custServiceJPA")
	private CustomerService jpaService;
	
	@Autowired
	@Qualifier("custServiceJDBC")
	private CustomerService jdbcService;
	
	
	
	@GetMapping("/jpa/getall")
	public List<Customer> getAll(){
		return jpaService.findAll();
	}
	
	@GetMapping("/jpa/bulk")
	public void bulk() {
		jpaService.bulkcreate();
	}
	
	@GetMapping("/jdbc/getall")
	public List<Customer> jdbcGetAll(){
		return jdbcService.findAll();
	}
	
	@GetMapping("/jdbc/bulk")
	public void jdbcBulk() {
		jdbcService.bulkcreate();
	}
	
	
	@GetMapping("/jdbc/byfirst/{first}")
	public List<Customer> jdbcByFirst(@PathVariable String first) {
		return jdbcService.findByFirstName(first);
	}
	
	@GetMapping("/jpa/byfirst/{first}")
	public List<Customer> jpaByFirst(@PathVariable String first) {
		return jpaService.findByFirstName(first);
	}
	
	/*@RequestMapping("/search/{id}")
	public String search(@PathVariable long id) {
		String customer = "";
		customer = repository.findById(id).toString();
		return customer;
	}

	@RequestMapping("/searchbyfirstname/{firstname}")
	public List<Customer> fetchDataByFirstName(@PathVariable String firstname) {

		return custJPA.findByFirstName(firstname);

	}*/
}
