<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.raj.utility.Cart ,com.raj.model.CartItem   " %>
<!DOCTYPE html>
<html>
<head>
    <title>Food Delivery - Cart</title>
    <link rel="stylesheet" type="text/css" href="cart.css">
</head>
<body>
    <h1 class="title">Your Cart</h1>

    <form action="checkout.jsp" method="get">
        <table class="cart-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%-- Replace with dynamic content from the server --%>
                <%-- 
                <%
                Cart cart=(Cart)session.getAttribute("cart");
                
                Integer rid=(Integer)session.getAttribute("restaurantId");
                
                if(cart!=null && !cart.getItems().isEmpty()){
                	for(CartItem item: cart.getItems().values()){
                
                
                
                %>
                <tr>
                    <td><%=item.getItemId() %></td>
                    <td><%=item.getItemName() %></td>
                    <td><%=item.getPrice() %></td>
                    <td><input type="number" name="quantity1" ><%=item.getQuantity() %></td>
                    <td>
                    <form action="callCart" method="get">
                    	<input type="hidden" name="itemId" value="<%=item.getItemId() %>">
                    	<input type="hidden" name="action" value="update">
                    	<input type="hidden" name="quantity" value="<%=item.getQuantity() - 1%>">
                        <button type="submit" name="decrement1" <% if(item.getQuantity()==1){ %>disabled<% } %>>-</button>
                    </form>
                    <form action="callCart" method="get">
                    	<input type="hidden" name="itemId" value="<%=item.getItemId() %>">
                    	<input type="hidden" name="action" value="update">
                    	<input type="hidden" name="quantity" value="<%=item.getQuantity() + 1%>">
                        <button type="submit" name="increment1" >+</button>
                        
                    </form>
                    </td>
                </tr>
                
                <%-- Add more rows dynamically as needed --%>
                <%-- 
                <%
                
                	}
                }
                %>
            </tbody>
        </table>

        <div class="checkout-container">
            <button type="submit" class="checkout-button">Proceed to Checkout</button>
        </div>
    </form>
</body>
</html>


--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.raj.utility.Cart, com.raj.model.CartItem" %>
<!DOCTYPE html>
<html>
<head>
    <title>Food Delivery - Cart</title>
    <link rel="stylesheet" type="text/css" href="cart.css">
</head>
<body>
    <h1 class="title">Your Cart</h1>

    
        <table class="cart-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                Cart cart = (Cart) session.getAttribute("cart");
                if (cart != null && !cart.getItems().isEmpty()) {
                    for (CartItem item : cart.getItems().values()) {
                %>
                <tr>
                    <td><%= item.getItemId() %></td>
                    <td><%= item.getItemName() %></td>
                    <td><%= item.getPrice() %></td>
                    <td><%= item.getQuantity() %></td>
                    <td>
                        <!-- Decrement Button -->
                        <form action="callCart" method="get" style="display:inline;">
                            <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="restaurantid" value="<%=item.getRestaurantId()%>">
                            <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
                            <button type="submit" <%--<% if (item.getQuantity() == 1) { %>disabled<% } %>--%>>-</button>
                        </form>

                        <!-- Increment Button -->
                        <form action="callCart" method="get" style="display:inline;">
                            <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
                            <input type="hidden" name="restaurantid" value="<%=item.getRestaurantId()%>">
                            <button type="submit">+</button>
                        </form>

                        <!-- Delete Button -->
                        <form action="callCart" method="get" style="display:inline;">
                            <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                            <input type="hidden" name="restaurantid" value="<%=item.getRestaurantId()%>">
                            <input type="hidden" name="action" value="remove">
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
                
                
                
                <tr>
    
                
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="5">Your cart is empty.</td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
		<form action="checkout.jsp">
        <div class="checkout-container">
            <button type="submit" class="checkout-button">Proceed to Checkout</button>
        </div>
        </form>
    
</body>
</html>


    