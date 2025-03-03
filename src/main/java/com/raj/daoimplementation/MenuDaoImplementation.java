package com.raj.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.raj.dao.MenuDao;
import com.raj.model.Menu;
import com.raj.utility.DBConnectivity;

public class MenuDaoImplementation implements MenuDao{

	@Override
	public List<Menu> getAllMenuByRestaurant(int rid) {
		
		
		String GET_ALL_MENU="select * from `menu` where restaurantid=?;";
		Connection con = DBConnectivity.getConnection();
		List<Menu> list=new ArrayList();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(GET_ALL_MENU);
			pstmt.setInt(1, rid);
			ResultSet res = pstmt.executeQuery();
			
			
			while(res.next())
			{
				Menu menu = extractMenu(res);
				
				list.add(menu);
			}
			return list;
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}
	
	
	static Menu extractMenu(ResultSet res) throws SQLException{
		int menuid=res.getInt("menuid");
		int restaurantid=res.getInt("restaurantid");
		String itemname=res.getString("itemname");
		String description=res.getString("description");
		float price=res.getFloat("price");
		String rating=res.getString("rating");
		String isavailable=res.getString("isavailable");
		String imagePath=res.getString("imagePath");
		
		Menu menu = new Menu(menuid, restaurantid, itemname, description, price, rating, isavailable, imagePath);
		return menu;
		
	}


	public Menu getMenu(int menuId) {
		
		String GET_MENU="select * from `menu` where menuid=?";
		
		Connection con = DBConnectivity.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(GET_MENU);
			pstmt.setInt(1, menuId);
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
			Menu menu = extractMenu(res);
			
			return menu;
			
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}
