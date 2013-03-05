<%@page import="store.*"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
  Product product = new Product((String) request.getParameter("id"));
%>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title><%= product.name %></title>
</head>

<body>
  <h1><%= product.name %></h1>
  <img src="store-images/<%= product.imagefile %>" alt="<%= product.name %>">
    <form action="addToCart" method="post">
    $<%= product.price.toPlainString() %> 
      <input name="productid" type="hidden" value="<%= product.productid %>"/>
      <input type="submit" value="Add to Cart">
    </form>
</body>
</html>