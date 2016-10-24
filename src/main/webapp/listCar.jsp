<%@ page import="com.jetmoney.Servlet.CarServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List car it parking</title>
</head>
<body>

<h3>List car in Parking:</h3>
<form action = "listCar" method = "get">
    <b>free place: </b>${freePlace}
    (<a href="carIn.jsp">Add car in parking</a>)
    (<a href="getCar.jsp">Check car in parking</a>)
<ol>
    <c:forEach items="${cars}" var="ParkingEntity">
        <li>
                ${ParkingEntity.carEntity.number} ${ParkingEntity.carEntity.brandName} date incoming ${ParkingEntity.dateIn}
                    <a href="getOut?id=${ParkingEntity.id}">get out from parking</a>
        </li>
    </c:forEach>
</ol>

</body>
</html>