<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
 <%@ page import="java.util.List,com.raj.model.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Delivery - Restaurants</title>
    <link rel="stylesheet" href="restaurant.css">
    
</head>
<body>
    <header>
        <h1>Food delivery application</h1>
    </header>
    <nav>
        <a href="index.html">Home</a>
        <a href="restaurants.html">Restaurants</a>
        <a href="menu.html">Menu</a>
        <a href="contact.html">Contact</a>
       
    </nav>
    <div class="container">
        <h2>Restaurants</h2>
        <div class="restaurant">
        
        <%
        
        List<Restaurant> restaurants=(List<Restaurant>)request.getAttribute("allrestaurants");
        	for(Restaurant r:restaurants){
        
        %>
            <a href="menu?restaurantid=<%=r.getRestaurantId() %>">
            <div class="restaurant-card">
                <img src=<%=r.getImagePath() %> alt="Restaurant 1">
                <h3><%=r.getName() %></h3>
                <p>Restaurant ID:<%= r.getRestaurantId() %></p>
                <p>Ratings: <%=r.getRating() %>/5</p>
                <p>Cuisine: <%=r.getCusineType() %></p>
            </div>
            </a>
            
          <%
        	}
          
          %>
            
        </div>
    </div>
</body>
</html>
    