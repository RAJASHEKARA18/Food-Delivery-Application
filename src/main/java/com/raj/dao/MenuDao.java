package com.raj.dao;

import java.util.List;

import com.raj.model.Menu;

public interface MenuDao {

	List<Menu> getAllMenuByRestaurant(int rid);
	
	
}
