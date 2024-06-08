package com.SpringHibernate;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {
	
	@Id
	private int lId;
	private String lName;
	
	@ManyToMany
	private ArrayList<Student> student = new ArrayList<>();
	
	public ArrayList<Student> getStudent(){
		return this.student;
	}
	
	public void setStudent(ArrayList<Student> student) {
		this.student =  student;
	}


	
//	@ManyToOne
//	private Student student;
//	
//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}

		public int getlId() {
		return lId;
	}
	
	public void setlId(int lId) {
		this.lId = lId;
	}
	
	public String getlName() {
		return lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public Laptop(int lId, String lName) {
		super();
		this.lId = lId;
		this.lName = lName;
	}
	
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Laptop [lId=" + lId + ", lName=" + lName + "]";
	}
	
}
