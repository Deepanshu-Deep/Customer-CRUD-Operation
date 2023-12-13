package com.customer.service;

import com.customer.exception.CustomerException;
import com.customer.model.Customer;
import java.util.List;

public interface CustomerService {

	public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Long custId,Customer customer) throws CustomerException;
	
	public Customer deleteCustomer(Long custId) throws CustomerException;
	
	public Customer viewByCustomerId(Long custId) throws CustomerException;
	
	public List<Customer> getAllCustomer() throws CustomerException;
	
	
}
