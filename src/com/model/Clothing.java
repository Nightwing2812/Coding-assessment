package com.model;

public class Clothing extends Product{
	private String size;
	private String color;
	public Clothing() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Clothing(int productId, String productName, String description, double price, int quantityInStock,
			String type) {
		super(productId, productName, description, price, quantityInStock, type);
		// TODO Auto-generated constructor stub
	}
	public Clothing(String productName, String description, double price, int quantityInStock, String type) {
		super(productName, description, price, quantityInStock, type);
		// TODO Auto-generated constructor stub
	}
	public Clothing(String size, String color) {
		super();
		this.size = size;
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Clothing [size=" + size + ", color=" + color + "]";
	}
	

}
