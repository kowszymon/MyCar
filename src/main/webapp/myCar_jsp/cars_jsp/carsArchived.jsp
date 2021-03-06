<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2019-05-22
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Samochody</title>
    <link rel="icon" href="https://img.icons8.com/ios/50/000000/people-in-car-filled.png">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="/myCar_jsp/nav.jsp"/>

<c:if test="${not empty errorMsg}">
    <div class="alert alert-danger" role="alert">
            ${errorMsg}
    </div>
</c:if>


<c:if test="${not empty message}">
    <div class="alert alert-success" role="alert">
            ${message}
    </div>
</c:if>


<div class="container">


    <h2>Lista Twoich zarchiwizowanych samochodów</h2>
    <table class="table table-dark table-striped w-auto">
        <thead>
        <tr>
            <th>Nazwa</th>
            <th>Marka</th>
            <th>Model</th>
            <th>Paliwo</th>
            <th>Spalanie</th>
            <th>Przebieg</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${carsModel}" var="car">
            <tr>
                <td>${car.name}</td>
                <td>${car.make}</td>
                <td>${car.model}</td>
                <td>${car.fuel}</td>
                <td>${car.fuelConsumptionPer100km}</td>
                <td>${car.course}</td>
                <td><a class="text-white" href="/car?id=${car.id}"><span title="Edytuj"><i class="far fa-edit"></i></span></a></td>
                <td><a class="text-white" href="/car/unarchive?id=${car.id}"
                       onclick="return confirm('Czy na pewno chcesz przywrócić ten samochód?');">
                    <span title="Przywróć"><i class="fas fa-undo"></i></span></a></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h4><a href="/car/list"><-- powrót do listy aktywnych samochodów</a></h4>
</div>


</body>
</html>
