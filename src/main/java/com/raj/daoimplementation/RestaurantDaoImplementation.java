package com.raj.daoimplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.raj.dao.RestaurantDao;
import com.raj.model.Restaurant;
import com.raj.utility.DBConnectivity;

public class RestaurantDaoImplementation implements RestaurantDao{

	@Override
	public List<Restaurant> getAllRestaurants() {
		
		String GET_ALL_RESTAURANTS="select * from `restaurant`";
		List<Restaurant> list = new ArrayList();
		
		Connection con = DBConnectivity.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(GET_ALL_RESTAURANTS);
			
			while(res.next())
			{
				
				Restaurant restaurant = extractRestaurant(res);
				list.add(restaurant);
				
				
			}
			return list;
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}
	
	static Restaurant extractRestaurant(ResultSet res) throws SQLException{
		
		int rid = res.getInt("restaurantid");
		String name=res.getString("name");
		String address=res.getString("address");
		String phone=res.getString("phone");
		String rating=res.getString("rating");
		String cusinetype=res.getString("cusineType");
		String isactive=res.getString("isactive");
		String eta=res.getString("eta");
		int adminuserid=res.getInt("adminuserid");
		String imagepath=res.getString("imagePath");
		
		Restaurant rest = new Restaurant(rid, name, address, phone, rating, cusinetype, isactive, eta, adminuserid, imagepath);
		return rest;
	}
	
}

