<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <jsp:useBean id="user" class="com.capgemini.springmvc.beans.User" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${msg }</h1>
	<h1><%=user.getName() %></h1>
</body>
</html>