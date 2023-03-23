<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>All leads</h1>
		<table>
		<tr>
		<th>FirstName</th>
	    <th>LastName</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>Delete</th>		
		<th>Update</th>		
		
		
		</tr>
		<c:forEach var = "lead" items = "${leads }">
		<tr>
		<td>${lead.firstName }</td>
		<td>${lead.lastName }</td>
		<td>${lead.email }</td>
		<td>${lead.mobile }</td>
		<td><a href = "delete?id=${lead.id }">delete</a></td>
		<td><a href = "update?id=${lead.id }">update</a></td>
		
		</tr>
		
		</c:forEach>
		</table>
</body>
</html>