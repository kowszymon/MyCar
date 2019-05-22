<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2019-04-28
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${AddOrEdit}</title>
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

<div class="container-fluid">
    <h2>${AddOrEdit}</h2>
    <c:if test="${not empty errorMsg}">
    <div class="alert alert-danger" role="alert">
            ${errorMsg}
    </div>
    </c:if>

    <c:if test="${not empty car}">
    <form action="/car/save" method ="post" class="was-validated">
        <div class="form-group">
            <label for="name">Nazwa:</label>
            <input type="text" class="form-control w-auto" id="name" placeholder="Wpisz nazwę samochodu" name="name" value="${car.name}" required>
            <div class="valid-feedback">OK</div>
            <div class="invalid-feedback">Pole obowiązkowe</div>
        </div>
        <div class="form-group">
            <label for="make">Marka</label>
            <input type="text" class="form-control w-auto" id="make" placeholder="Wpisz markę" name="make" value="${car.make}">
        </div>
        <div class="form-group">
            <label for="model">Model:</label>
            <input type="text" name="model" class="form-control w-auto" placeholder="Wpisz model" id="model" value="${car.model}">
        </div>


        <div class="form-group">
            <label for="fuelConsumptionPer100km">Średnie spalanie w litrach na 100km</label>
            <input type="number" step="0.1" min=0  name="fuelConsumptionPer100km" class="form-control w-auto"
                   id="fuelConsumptionPer100km"
                   value = "${car.fuelConsumptionPer100km}">
        </div>


        <div class="form-group">
            <label>Paliwo</label>
                <select name = "fuel">
                    <option></option>
                    <c:forEach items="${fuelTypes}" var="fuel">
                        <option class="form-control w-auto" value="${fuel}" ${fuel.name.equals(selectedFuel) ? 'selected = "selected"' : ''}>${fuel.name}</option>
                    </c:forEach>
                </select>
        </div>



        <div class="form-group">
            <label for="course">Przebieg</label>
            <input type="number" min=0 class="form-control w-auto" id="course" placeholder="Podaj przebieg w km" name="course" value ="${car.course}">
        </div>
        <input type="hidden" name="id" value="${car.id}">

        <input type="hidden" name="status" value="${status}">

        <button type="submit" class="btn btn-primary">Potwierdź</button>
    </form>
    </c:if>
</div>
</body>
</html>
