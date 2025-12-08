<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RailwayReservation Login Page</title>
</head>
<body>

<form:form action="confirmationform" modelAttribute="reservation">
<p> Welcome to Railway Reservation.Please enter your details</p>
Enter your first name : <form:input path="firstname" /><br><br>
Enter your last name : <form:input path="lastname" /><br><br>
Gender : 
Male <form:radiobutton path="gender" value ="Male"/>
Female<form:radiobutton path = "gender" value = "Female"/><br><br>
Meals:
BreakFast <form:checkbox path="food" value ="BreakFast"/>
Lunch <form:checkbox path="food" value ="Lunch"/>
Dinner <form:checkbox path="food" value ="Dinner"/><br><br>

Leaving From :<form:select path="cityFrom">
<form:option value="Hyderabad" label = "Hyderabad"/>
<form:option value="Nalgonda" label = "Nalgonda"/>
<form:option value="Mumbai" label = "Mumbai"/>
<form:option value="Benglore" label = "Benglore"/>
<form:option value="Chennai" label = "Chennai"/>
</form:select>
<br><br>
Going to  :<form:select path="cityTo">
<form:option value="Hyderabad" label = "Hyderabad"/>
<form:option value="Nalgonda" label = "Nalgonda"/>
<form:option value="Mumbai" label = "Mumbai"/>
<form:option value="Benglore" label = "Benglore"/>
<form:option value="Chennai" label = "Chennai"/>
</form:select>
<br><br>
<input type="submit" />

</form:form>

</body>
</html>
