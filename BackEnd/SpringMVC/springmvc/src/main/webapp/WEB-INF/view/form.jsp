<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>${name}</h2>
<h2>${email}</h2>
<h2>${password}</h2>
<h2>${gender}</h2>

	<form action="./form" method="post">
	<table>
	<tr>
		<td>Name:</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>email:</td>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<td>password:</td>
		<td><input type="text" name="password"></td>
	</tr>
	<tr>
		<td>Gender:</td>
		<td><input type="radio" name="gender" value="m">Male</td>
		<td><input type="radio" name="gender" value="f">Female</td>
	</tr>
	<tr>
		<td><input type="reset" value="reset"></td>
		<td><input type="submit" value="submit"></td>
	</tr>
	</table>
	</form>
</body>
</html>