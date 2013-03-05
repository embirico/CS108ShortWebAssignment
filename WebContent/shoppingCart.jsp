<%@page import="store.*, java.util.Map"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
<%
  ShoppingCart cart = (ShoppingCart) session.getAttribute(SessionListener.SHOPPING_CART);
  Map<String, Integer> cartMap = cart.getCart();
%>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Shopping Cart</title>
</head>

<body>
  <h1>Shopping Cart</h1>
  
  <form action="updateCart" method="post">
  <ul>
	<%
	for (String productid: cartMap.keySet()) {
	  Product product = new Product(productid);
	  out.print("<li>");
	  out.print("<input type=\"text\" name=\"" + productid + "\"");
	  out.print("value=\"" + cartMap.get(productid).toString() + "\">");
	  out.print(product.name + ", $" + product.price.toPlainString());
	  out.print("</li>");
    }
    %>
  </ul>
  Total: $<%= cart.getTotalCost().toPlainString() %>
  <input type="submit" value="Update Cart">
  </form>
  
  <p><a href="home.jsp">Continue Shopping</a></p>
</body>
</html>