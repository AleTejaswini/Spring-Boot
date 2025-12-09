<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>
 	<h1> Employee List</h1>
 	<a href = "add"> Add Employee </a>
 	
 	<table border = "1">
 	<tr> <th>ID</th> <th> Name </th> </tr>
 	
 	<c:forEach var="e" items="${employeelist}">
 	<tr> <td>${e.empid}</td>
 	<td>${e.empname}</td>
 	<td>
 	<a href="/edit/${e.empid}">Edit</a>
 	<a href = "/delete/${e.empid}">Delete</a>
 	</td>
 	</tr>
 	</c:forEach>
 	</table>

</body>
</html>