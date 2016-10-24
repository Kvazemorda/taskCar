<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Car go in parking</title>
</head>
<body>
    <form action = "listCar" method = "post">
        <label for = "number"> Input number car:
            <input type = "text" id = "number" value="${CarEntity.number}" name = "number">
        </label>
        <label for = "brandName"> Input brand name car:
            <input type = "text" id = "brandName" value="${CarEntity.brandName}" name = "brandName">
        </label> <br/>
        <input type ="submit" value="save" />
    </form>
</body>
</html>
