package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.exception.CustomerException;
import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public Customer addCustomer(Customer customer){
		
		Customer addCustomer = customerRepository.save(customer);
		
		return addCustomer;
	}

	@Override
	public Customer updateCustomer(Long custId, Customer customer) throws CustomerException {
		
		Customer existingCustomer = customerRepository.findById(custId).orElseThrow(() -> new CustomerException("Customer", "id", custId)) ;
		
		existingCustomer.setFirst_name(customer.getFirst_name());
		existingCustomer.setLast_name(customer.getLast_name());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setStreet(customer.getStreet());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setCity(customer.getCity());
        existingCustomer.setState(customer.getState());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
		
		return customerRepository.save(existingCustomer);
	}

	@Override
	public Customer deleteCustomer(Long custId) throws CustomerException {
		
		
		Customer existingCustomer = customerRepository.findById(custId).orElseThrow(() -> new CustomerException("Customer", "id", custId)) ;

		
		customerRepository.deleteById(custId);
		 
		 return existingCustomer;
	}

	@Override
	public Customer viewByCustomerId(Long custId) throws CustomerException {
		
		Customer existingCustomer = customerRepository.findById(custId).orElseThrow(() -> new CustomerException("Customer", "id", custId)) ;

		
		customerRepository.findById(custId);
		 
		 return existingCustomer;
		
		
	}

	@Override
	public List<Customer> getAllCustomer() throws CustomerException {
		
		
		
		return customerRepository.findAll();
	}

	
	
}
