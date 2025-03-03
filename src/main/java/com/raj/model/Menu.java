package com.raj.model;

public class Menu {
	private int menuId;
	private int restaurantId;
	private String itemName;
	private String description;
	private float price;
	private String rating;
	private String isAvailabe;
	private String imagePath;
	
	public Menu() {
		
	}

	public Menu(int menuId, int restaurantId, String itemName, String description, float price, String rating,
			String isAvailabe, String imagePath) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.isAvailabe = isAvailabe;
		this.imagePath = imagePath;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getIsAvailabe() {
		return isAvailabe;
	}

	public void setIsAvailabe(String isAvailabe) {
		this.isAvailabe = isAvailabe;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
