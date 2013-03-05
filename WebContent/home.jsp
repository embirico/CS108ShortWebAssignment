<%@page import="store.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Student Store</title>
</head>

<body>
  <h1>Student Store</h1>
  <p>Items available:<p>
  <ul>
	<%
	ProductCatalog catalog = (ProductCatalog) application.getAttribute("ProductCatalog");
	for (Product product: catalog.getProductsList()) {
	  out.print("<li>");
	  out.print("<a href=\"show-product.jsp?id=" + product.productid + "\">");
	  out.print(product.name);
	  out.println("</li>");
    }
    %>
  </ul>
</body>
</html>