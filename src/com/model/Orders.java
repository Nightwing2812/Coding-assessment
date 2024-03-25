package com.model;

public class Orders {
	private int productId;
	private int userId;
	private int quantity;
	private int totalPrice;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(int productId, int userId, int quantity, int totalPrice) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Orders [productId=" + productId + ", userId=" + userId + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + "]";
	}
	
	
	

}
