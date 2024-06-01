package com.kaustubh.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Fafda {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Fafda [price=" + price + "]";
	}

	public Fafda() {
		super();
	}
	
	
	@PostConstruct
	public void start() {
		System.out.println("method : start");
	}
	
	
	@PreDestroy
	public void destroy() {
		System.out.println("method : destroy");
	}
	

}
