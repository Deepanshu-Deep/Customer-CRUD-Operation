package com.customer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Getter
@Setter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	

	private String first_name;
	

	private String last_name;
	

	private String street;
	

	private String address;
	

	private String city;
	
	
	private String state;
	

	private String email;
	
	
	private String phone;
	
	
	
}
