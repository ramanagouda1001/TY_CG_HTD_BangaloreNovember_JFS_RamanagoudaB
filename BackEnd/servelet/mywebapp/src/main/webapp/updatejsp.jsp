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
<%if(msg!=null && !msg.isEmpty()) {%>
<%=msg %>
<%} %>

	<h4><a href="./HomeJSP.jsp"></a></h4>	
	<fieldset>
	<legend>update Employee</legend>
	<form action="./uppdateEmployee22" method="post">
		<table>
			<tr>
				<td>Employee ID</td>
				<td>:</td>
				<td><input type="number" name="empId" required></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td>:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Age</td>
				<td>:</td>
				<td><input type="number" name="age"></td>
			</tr>
			<tr>
				<td>salary</td>
				<td>:</td>
				<td><input type="number" name="salary"></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td>:</td>
				<td><input type="text" name="desgination" ></td>
			</tr>
			<tr>
				<td>Password</td>
				<td>:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><br>
				<input type="submit" value="add">
			</tr>
		</table>
	</form>
</fieldset>
</body>
</html>