package com.raj.model;

public class CartItem {
	
	private int itemId;
	private String itemName;
	private float price;
	private int quantity;
	private int restaurantId;
	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}

	public CartItem(int itemId, String itemName, float price, int quantity, int restaurantId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
		this.restaurantId = restaurantId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	
	
}
