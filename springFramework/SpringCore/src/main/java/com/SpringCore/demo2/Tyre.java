package com.SpringCore.demo2;

public class Tyre {
	private String brand;
	
	
	public Tyre(String brand) {
		super();
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Tyre [brand= " + brand + " ]" + " its working";
	}	
}