package com.raj.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.raj.daoimplementation.RestaurantDaoImplementation;
import com.raj.model.Restaurant;

/**
 * Servlet implementation class Restaurant
 */
@WebServlet("/home")
public class RestaurantServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RestaurantDaoImplementation rdi = new RestaurantDaoImplementation();
		List<Restaurant> restaurants = rdi.getAllRestaurants();
		
		request.setAttribute("allrestaurants", restaurants);
		
		RequestDispatcher rd = request.getRequestDispatcher("restaurant.jsp");
		rd.forward(request, response);
	}

	
}

