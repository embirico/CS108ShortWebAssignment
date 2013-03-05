<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title><%= (String) request.getAttribute("title") %></title>
</head>

<body>
  <h1><%= (String) request.getAttribute("header") %></h1>
  <p><%= (String) request.getAttribute("prompt") %></p>
  
  <form action="<%= (String) request.getAttribute("action") %>" method="post">
    User Name:<input type="text" name="username"><br>
    Password:<input type="password" name="password">
    <input type="submit" value="Login">
  </form>
  
  <%
  if ( (Boolean)request.getAttribute("newAccountOption") ) {
  	out.println("<a href=\"createAccount\">Create New Account</a>");
  }
  %>
</body>
</html>