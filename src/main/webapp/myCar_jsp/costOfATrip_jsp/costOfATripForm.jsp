<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2019-05-02
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Policz koszt przejazdu</title>
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
    <h2>Policz koszt przejazdu</h2>
    <c:if test="${not empty errorMsg}">
        <div class="alert alert-danger" role="alert">
                ${errorMsg}
        </div>
    </c:if>

        <form action="/costOfATrip/result" method ="get" class="was-validated">
            <div class="form-group">
                <label>Samochód</label>
                <select name = "carId">
                    <c:forEach items="${carsModel}" var="car">
                        <option value="${car.id}">${car.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="passengersQty">Ilość osób</label>
                <input type="text" class="form-control" id="passengersQty" placeholder="Wpisz ilość osób podróżujących" name="passengersQty" value="${passengersQty}" required>
                <div class="valid-feedback">OK</div>
                <div class="invalid-feedback">Pole obowiązkowe</div>
            </div>


            <div class="form-group">
                <label for="tripLength">Długość trasy</label>
                <input type="number" min=0  name="tripLength" class="form-control"
                       placeholder="Podaj długość trasy w kilometrach" id="tripLength"
                       value = "${tripLength}" required>
                <div class="valid-feedback">OK</div>
                <div class="invalid-feedback">Pole obowiązkowe</div>
            </div>


            <button type="submit" class="btn btn-primary">Potwierdź</button>
        </form>
</div>
</body>
</html>
