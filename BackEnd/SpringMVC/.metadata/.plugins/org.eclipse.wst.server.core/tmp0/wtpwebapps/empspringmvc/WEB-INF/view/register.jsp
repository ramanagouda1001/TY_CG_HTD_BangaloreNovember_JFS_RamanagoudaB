<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./register" method="post">
		<fieldset>
			<legend>Employee Details</legend>
			<table>
				<tr>
					<td>Name</td>
					<td>:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td>:</td>
					<td><input type="email" name="email"></td>
				</tr>

				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			<legend>Employee Address Details</legend>
			<table>
				<tr>
					<td>Address Type</td>
					<td>:</td>
					<td><select name="addressBeans[0].addType">
							<option>-------select----------</option>
							<option value="p">Permament</option>
							<option value="t">Tempapory</option>
					</select></td>
				</tr>
				<tr>
					<td>Address 1</td>
					<td>:</td>
					<td><input type="text" name="addressBeans[0].address1"></td>
				</tr>
				<tr>
					<td>Address 2</td>
					<td>:</td>
					<td><input type="text" name="addressBeans[0].address2"></td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			<legend>Employee Address Details 1</legend>
			<table>
				<tr>
					<td>Address Type</td>
					<td>:</td>
					<td><select name="addressBeans[1].addType">
							<option>-------select----------</option>
							<option value="p">Permament</option>
							<option value="t">Tempapory</option>
					</select></td>
				</tr>
				<tr>
					<td>Address 1</td>
					<td>:</td>
					<td><input type="text" name="addressBeans[1].address1"></td>
				</tr>
				<tr>
					<td>Address 2</td>
					<td>:</td>
					<td><input type="text" name="addressBeans[1].address2"></td>
				</tr>
			</table>
		</fieldset>
		<input type="submit" value="Register">
	</form>
</body>
</html>