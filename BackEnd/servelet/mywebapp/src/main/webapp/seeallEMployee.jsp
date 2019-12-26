<%@page import="com.capgemini.mywebapp.bean.EmployeeInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
    <%List<EmployeeInfoBean> list=(List<EmployeeInfoBean>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(list!=null && !list.isEmpty()) {%>
	<table>
  <tr>
    <th>ID</th>
    <th>NAme</th>
    <th>age</th>
    <th>salary</th>
    <th>des</th>
  </tr>
 <% for(EmployeeInfoBean t:list){%>
  <tr>
  <td><%=t.getEmp_id() %></td>
  <td><%=t.getName() %></td>
  <td><%=t.getAge() %></td>
  <td><%=t.getSalary() %></td>
  <td><%=t.getDesignation() %></td>
   </tr>
   <%} %>
</table>

<%} else {%>
<%} %>


</body>
</html>