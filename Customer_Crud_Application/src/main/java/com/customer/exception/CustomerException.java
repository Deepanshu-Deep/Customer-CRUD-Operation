package com.customer.exception;

public class CustomerException extends RuntimeException{

	String resourceName;
	String fieldName;
	long value;
	
	
	public CustomerException(String resourceName, String fieldName, long value) {
		super(String.format("%s not found with %s : %l", resourceName, fieldName, value));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.value = value;
	}


	public String getResourceName() {
		return resourceName;
	}


	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}


	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	public long getValue() {
		return value;
	}


	public void setValue(long value) {
		this.value = value;
	}
	
	

	
	
}
