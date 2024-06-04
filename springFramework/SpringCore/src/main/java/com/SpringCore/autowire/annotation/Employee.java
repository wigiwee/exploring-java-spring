package com.SpringCore.autowire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
	@Autowired
	@Qualifier("temp2")
	private Address address;

	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {

		this.address = address;
	}

	public Employee() {
		super();
	}

	public Employee(Address address) {
		super();
		this.address = address;
	}

	@Override
	public String toString() {
		return "{" +
			" address='" + getAddress() + "'" +
			"}";
	}
}
