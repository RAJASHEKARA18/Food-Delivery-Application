package com.raj.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.raj.daoimplementation.MenuDaoImplementation;
import com.raj.model.Menu;

/**
 * Servlet implementation class MenuServlet
 */

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
						//System.out.println("menuservlet gets called");
						int rid=Integer.parseInt(request.getParameter("restaurantid"));
						//System.out.println(rid);
						
						MenuDaoImplementation mdi = new MenuDaoImplementation();
						
						List<Menu> allmenus = mdi.getAllMenuByRestaurant(rid);
						System.out.println(allmenus);
						
						request.setAttribute("allmenus", allmenus);
						
						RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
						
						rd.forward(request, response);
		
		
			}

	
}
