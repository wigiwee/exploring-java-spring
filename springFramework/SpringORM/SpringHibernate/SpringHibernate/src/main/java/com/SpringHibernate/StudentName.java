package com.SpringHibernate;

import jakarta.persistence.Embeddable;


@Embeddable //this annotation makes this class object to be saved in the same table
public class StudentName {
	private String lastName, middleName, firstName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public StudentName() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentName(String firstName, String middleName, String lastName) {
		super();
		this.lastName = lastName;
		this.middleName = middleName;
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "StudentName [lastName=" + lastName + ", middleName=" + middleName + ", firstName=" + firstName + "]";
	}
	

	
	
}
