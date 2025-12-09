<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
</head>
<body>
<h2> Edit Employee</h2>
<form action = "/update" method ="post">
<input type="hidden" name="empid" value="${emp.empid}">
Name: <input type= "text" name="empname" value ="${emp.empname}">
<input type = "Submit"> 
</form>
</body>
</html>