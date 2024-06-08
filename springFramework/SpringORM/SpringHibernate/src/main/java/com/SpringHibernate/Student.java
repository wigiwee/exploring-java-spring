package com.SpringHibernate;




import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity(name = "Student") //entity name, by default table name
@Table(name = "Student") //table name
public class Student {
	@Id 				//primary key defined here
	@Column(name = "id") //column name can be changed here
	private int id;
	
	private StudentName name;
	
	@Column(name = "city")
	private String city;
	
	@Transient 			//defines that the property won't we stored in database 
	private String phoneNo; //will not be stored in database table

	@ManyToMany(mappedBy = "student")
	private ArrayList<Laptop> laptop;
	
	public ArrayList<Laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(ArrayList<Laptop> laptop) {
		this.laptop = laptop;
	}
	
//	@OneToOne            //each student only has one laptop
//	private Laptop laptop;
//
//	public Laptop getLaptop() {
//		return laptop;
//	}
//
//	public void setLaptop(Laptop laptop) {
//		this.laptop = laptop;
//	}
	
//	@OneToMany(mappedBy = "student") //student is a variable name in Laptop class
//	private List<Laptop> laptop = new ArrayList<Laptop>();
//
//	public List<Laptop> getLaptops() {
//		return laptop;
//	}
//
//	public void setLaptops(List<Laptop> laptop) {
//		this.laptop = laptop;
//	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StudentName getName() {
		return name;
	}

	public void setName(StudentName name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", phoneNo=" + phoneNo + ", laptop=" + laptop
				+ "]";
	}

	public Student(int id, StudentName name, String city, ArrayList<Laptop>  laptop) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.laptop = laptop;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
