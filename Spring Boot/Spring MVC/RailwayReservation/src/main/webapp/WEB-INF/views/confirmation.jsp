<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation Page</title>
</head>
<body>
<p> Your Reservation is successfull.Please recheck the details</p>

FirstName : ${reservation.firstname}<br><br>
LastName  : ${reservation.lastname}<br><br>
Gender    : ${reservation.gender}<br><br>
Meals     :
<ul>  
<c:forEach var="meal" items="${reservation.food}">  
<li>${meal}</li>  
</c:forEach>  
</ul>  

Leaving From : ${reservation.cityFrom} <br><br>
Going to : ${reservation.cityTo}
</body>
</html>