package com.raj.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.raj.daoimplementation.MenuDaoImplementation;
import com.raj.model.CartItem;
import com.raj.model.Menu;
import com.raj.utility.Cart;

/**
 * Servlet implementation class CartServlet
 */

@WebServlet("/callCart")
public class CartServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		
		int newRestaurantId=Integer.parseInt(request.getParameter("restaurantid"));
		Integer currentRestaurantId = (Integer)session.getAttribute("restaurantid");
		
		
		if(cart==null || newRestaurantId!=currentRestaurantId) {
			cart=new Cart();
			
			session.setAttribute("cart",cart);
			session.setAttribute("restaurantid", newRestaurantId);
		}
		
		
		String action=request.getParameter("action");
		//String redirectPage = "menu.jsp"; // Default to redirecting to the menu page

		
		System.out.println(action);
		
		if(action.equals("add")) {
			addItemToCart(request,cart);
			
			int rid = Integer.parseInt(request.getParameter("restaurantid"));
		    response.sendRedirect("menu?restaurantid=" + rid);
			
		}
		
		else if(action.equals("update")) {
			updateCartItem(request,cart);
			response.sendRedirect("cart.jsp?restaurantid=" + newRestaurantId);
			
		}
		
		else if(action.equals("remove")) {
			removeItemFromCart(request,cart);
			response.sendRedirect("cart.jsp?restaurantid=" + newRestaurantId);
			
			
		}
		
		//response.sendRedirect("menu.jsp");
		//int rid = Integer.parseInt(request.getParameter("restaurantid"));
	    //response.sendRedirect("menu?restaurantid=" + rid);
		
		//String redirectUrl = request.getHeader("referer"); // Get the referring page
        //response.sendRedirect(redirectUrl != null ? redirectUrl : "menu.jsp");
		
		
		
		
	}

	private void addItemToCart(HttpServletRequest request, Cart cart) {
		
		
		int itemId = Integer.parseInt(request.getParameter("menuid"));
		
		System.out.println(itemId);
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		MenuDaoImplementation menuDao = new MenuDaoImplementation();
		Menu menuItem = menuDao.getMenu(itemId);
		
		System.out.println(menuItem);
		
		
		if(menuItem!=null) {
			CartItem item = new CartItem(
					
					menuItem.getMenuId(),
					menuItem.getItemName(),
					menuItem.getPrice(),
					quantity,
					menuItem.getRestaurantId()
					);
			cart.addItem(item);
			
		}
		
		
		
	}
	
	
	
	
	private void removeItemFromCart(HttpServletRequest request, Cart cart) {
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		cart.removeItem(itemId);
		
	}

	private void updateCartItem(HttpServletRequest request, Cart cart) {
		
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		cart.updateItem(itemId, quantity);
		
	}


}
