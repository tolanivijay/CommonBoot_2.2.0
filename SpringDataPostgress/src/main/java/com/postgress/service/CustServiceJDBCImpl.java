package com.postgress.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.postgress.Customer;

@Service("custServiceJDBC")
public class CustServiceJDBCImpl implements CustomerService{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String tableName = "customer";

	@Override
	public List<Customer> findAll() {
		String query = "select * from "+tableName;
		return jdbcTemplate.query(query, new CustMapper());
	}

	@Override
	public void bulkcreate() {
		System.out.println("Added "+addToCustomer("Rahul","Dravid"));
		System.out.println("Added "+addToCustomer("Sachin","Tendulkar"));
		System.out.println("Added "+addToCustomer("MS","Dhoni"));
		
	}
	
	private Number addToCustomer(String first,String last) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName(tableName)
				.usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("firstname", first);
		parameters.put("lastname", last);
		return insert.executeAndReturnKey(parameters);

	}
	
	class CustMapper implements RowMapper<Customer> {

		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer cust = new Customer();
			cust.setId(rs.getLong("id"));
			cust.setFirstName(rs.getString("firstname"));
			cust.setLastName(rs.getString("lastname"));
			
			return cust;
		}
	}

	@Override
	public List<Customer> findByFirstName(String first) {
		String query = "select * from "+tableName +" where firstname ='"+first +"'";
		System.out.println("Query is "+query);
		return jdbcTemplate.query(query, new CustMapper());
	}


}
