<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List,com.raj.model.Menu" %>
<!-- Menu Page -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Delivery - Menu</title>
    <link rel="stylesheet" href="menu.css">
        
</head>
<body>
    <header>
        <h1>Menu</h1>
        
    </header>
    <nav>
        <a href="index.html">Home</a>
        <a href="restaurants.html">Restaurants</a>
        <a href="menu.html">Menu</a>
        <a href="contact.html">Contact</a>
        <a href="cart.jsp"><div class="cart">Cart</div></a>
    </nav>
    <div class="container">
        <h2>Menu</h2>
        <div class="menu">
        <%
        
        List<Menu> allmenus=(List<Menu>)request.getAttribute("allmenus");
        
        for(Menu m:allmenus){
        
        
        %>
            <div class="menu-item">
                <img src=<%=m.getImagePath() %> alt="menu">
                <h4>Menu id:<%=m.getMenuId() %></h4>
                
                <h4><%=m.getItemName() %></h4>
                <p><%=m.getPrice() %></p>
                <h4>ratings:<%=m.getRating() %>/5</h4>
                <a href="callCart?restaurantid=<%=m.getRestaurantId()%>&action=add&menuid=<%=m.getMenuId()%>&quantity=1">
    <button>Add to Cart</button>
</a>
                
                

                
            </div>
          <%
        }
          %>
            
            
        </div>
    </div>
</body>
</html>
    