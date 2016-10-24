<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Check car in parking</title>
</head>
<body>
    <form action = "getCar" method = "get">
        <label for = "number"> Input number car:
            <input type = "text" id = "number" value="${CarEntity.number}" name = "number">
        </label>
        <br/>
        <input type ="submit" value="check car" />
    </form>

    <p>
        ${car.number} ${car.brandName} ${carThis}
        ${nocar}
    </p>
    </br>
    <a href="listCar">return to list Car</a>
</body>
</html>
