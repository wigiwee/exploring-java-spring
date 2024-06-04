package com.SpringCore.autowire.usingXML;


public class Employee {
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
