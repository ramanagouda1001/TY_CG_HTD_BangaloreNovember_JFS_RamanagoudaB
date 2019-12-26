<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page session="false" %>
    <%String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(msg!=null && !msg.isEmpty()){ %>
<%=msg %>
<%} %>
<fieldset>
		<legend>Delete Employee</legend>
		<form action="./deleteEmployee6" method="get">
		Employee Id:<input type="number" name="empId" required><br>
		<input type="submit" value="delete">
		</form>
	</fieldset>
</body>
</html>