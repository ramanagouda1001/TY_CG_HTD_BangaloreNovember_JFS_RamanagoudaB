<%@page import="com.capgemini.mywebapp.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
   <% HttpSession session=request.getSession(false);
   EmployeeInfoBean bean=(EmployeeInfoBean)session.getAttribute("bean"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome <%=bean.getName() %></h1>
<a href="./add">ADD Employee</a>
<a href="./delete">Delete Employee</a>
<a href="./searchjsp">serach Employee</a>
<a href="./update">modify Employee</a>
<a href="./seeAllEmployee">Get all Employee</a>
<a href="./logout2">Logout2</a>

</body>
</html>