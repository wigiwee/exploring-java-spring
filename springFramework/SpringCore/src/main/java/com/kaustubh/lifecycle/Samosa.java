package com.kaustubh;

public class Samosa {
    private double price;

    @Override
    public String toString() {
        return "Samosa{" +
                "price=" + price +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public Samosa() {
		super();
	}

	public void setPrice(double price) {
		System.out.println("Setting price");
        this.price = price;
    }

    public Samosa(double price) {
        this.price = price;
    }
    public void init() {
    	System.out.println("insite init method");
    }
    public void destroy() {
    	System.out.println("inside destroy method");
    }
}
