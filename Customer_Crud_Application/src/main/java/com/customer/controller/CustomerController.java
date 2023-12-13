package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.exception.CustomerException;
import com.customer.model.Customer;
import com.customer.service.CustomerServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	@PostMapping
	ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer){
		
		 Customer addedCustomer = customerServiceImpl.addCustomer(customer);
		 
	     return new ResponseEntity<>(addedCustomer, HttpStatus.CREATED);
	     
	}
	
	
	@PutMapping("/{id}")
	ResponseEntity<Customer> updateByIdCustomerHandler(@RequestBody Customer customer, @PathVariable long id)throws CustomerException {
		
		 Customer updatedCustomer = customerServiceImpl.updateCustomer(id, customer);
		 
	     return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	     
	}
	
	
	@DeleteMapping("/{id}")
	ResponseEntity<Customer> deleteByIdCustomerHandler(@PathVariable long id)throws CustomerException {
		
		customerServiceImpl.deleteCustomer(id);
		
        return new ResponseEntity<>(HttpStatus.OK);
        
	}
	
	
	
	@GetMapping("/{id}")
    public ResponseEntity<Customer> viewByIdCustomerHandler(@PathVariable Long id) throws CustomerException {
       
		Customer customer = customerServiceImpl.viewByCustomerId(id);
        
		return new ResponseEntity<>(customer, HttpStatus.OK);
    }
	
	
	@GetMapping
	ResponseEntity<List<Customer>> viewAllCustomerHandler(){
		
		List<Customer> customer = customerServiceImpl.getAllCustomer();
        
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	
	
}
