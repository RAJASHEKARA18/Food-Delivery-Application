package com.raj.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.DoubleStream;

import com.raj.model.CartItem;

public class Cart {
	private HashMap<Integer, CartItem> items;

    // Constructor
    public Cart() {
        this.items = new HashMap<>();
    }

    // Add a CartItem to the cart
    public void addItem(CartItem item) {
        if (items.containsKey(item.getItemId())) {
            // If the item already exists, update the quantity
            CartItem existingItem = items.get(item.getItemId());
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            items.put(item.getItemId(), item);
        }
    }

    // Delete a CartItem from the cart by its ID
    public void removeItem(int id) {
    	
    	items.remove(id);
    	
            }

    // Update the quantity of a CartItem by its ID
    public void updateItem(int id, int newQuantity) {
        if (items.containsKey(id)) {
        	if(newQuantity <=0) {
        		items.remove(id);
        	}
        	else
        	{
        		CartItem item = items.get(id);
                item.setQuantity(newQuantity);
        	}
            
        }
    }
    
    
    
    public Map<Integer, CartItem> getItems(){
    	return items;
    }
    
    public DoubleStream getTotalPrice() {
    	return items.values().stream().mapToDouble(item -> item.getPrice()*item.getQuantity());
    }
	
    public void clear() {
    	items.clear();
    }
}

