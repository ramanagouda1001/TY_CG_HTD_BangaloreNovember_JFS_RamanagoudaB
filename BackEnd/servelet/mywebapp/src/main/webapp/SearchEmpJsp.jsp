<%@page import="com.capgemini.mywebapp.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
    <% EmployeeInfoBean bean=(EmployeeInfoBean)request.getAttribute("bean"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
		<legend>Search Employee</legend>
		<form action="./get" method="get">
		Employee ID:<input type="number" name="empid" required> <br>
		<input type="submit" value="Search">
		
		</form>
	</fieldset>
<br><br>

<%if (bean==null){%>
<h3>not present</h3>
<%}else{%>
Employee name=<%=bean.getName()%>
<%}%>
</body></html>