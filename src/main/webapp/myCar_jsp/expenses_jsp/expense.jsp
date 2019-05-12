<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2019-04-28
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dodaj wydatek</title>
    <link rel="icon" href="https://img.icons8.com/ios/50/000000/people-in-car-filled.png">
    <title>Dodaj samochód</title>
    <link rel="icon" href="https://img.icons8.com/ios/50/000000/people-in-car-filled.png">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <!--  jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

    <%--<!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->--%>
    <%--<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />--%>

    <!-- Bootstrap Date-Picker Plugin -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
</head>
<body>
<jsp:include page="/myCar_jsp/nav.jsp"/>

<div class="container-fluid">
    <h2>Edytuj wydatek</h2>
<c:choose>
    <c:when test="${not empty errorMsg}">
        <div class="alert alert-danger" role="alert">
                ${errorMsg}
        </div>
        <h4><a href="/home"><-- powrót do menu</a></h4>
    </c:when>
    <c:when test="${not empty errorMsgNotEnoughBudget}">
        <div class="alert alert-danger" role="alert">
                ${errorMsgNotEnoughBudget}
            <a href="/income/add">Zwiększ budżet</a>
        </div>
        <h4><a href="/expense/add"><-- dodaj inny wydatek</a></h4>
        <h4><a href="/home"><-- powrót do menu</a></h4>
    </c:when>
    <c:when test="${not empty errorMsgNoCarAndCategory}">
        <div class="alert alert-danger" role="alert">
                ${errorMsgNoCarAndCategory}
            <a href="/car/add">Dodaj samochód</a>
            <a href="/category/add">Dodaj kategorię</a>
        </div>
        <h4><a href="/home"><-- powrót do menu</a></h4>
    </c:when>
    <c:when test="${not empty errorMsgNoCar}">
        <div class="alert alert-danger" role="alert">
                ${errorMsgNoCar}
            <a href="/car/add">Dodaj samochód</a>
        </div>
        <h4><a href="/home"><-- powrót do menu</a></h4>
    </c:when>
    <c:when test="${not empty errorMsgNoCategory}">
        <div class="alert alert-danger" role="alert">
                ${errorMsgNoCategory}
            <a href="/category/add">Dodaj kategorię</a>
        </div>
        <h4><a href="/home"><-- powrót do menu</a></h4>
    </c:when>
<c:otherwise>
    <c:if test="${not empty expense}">
        <form action="/expense/save" method ="post" class="was-validated">
            <div class="form-group">
                <label class="control-label" for="car">Samochód</label>
                <select id="car" name="carId" required>
                    <c:forEach items="${carsModel}" var="car">
                        <option value="${car.id}">${car.name}</option>
                    </c:forEach>
                </select>
                <div class="valid-feedback">OK</div>
                <div class="invalid-feedback">Pole obowiązkowe</div>
            </div>
            <div class="form-group">
                <label class="control-label" for="category">Kategoria</label>
                <select id="category" name="categoryId" required>
                    <c:forEach items="${categoriesModel}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
                <div class="valid-feedback">OK</div>
                <div class="invalid-feedback">Pole obowiązkowe</div>
            </div>
            <div class="form-group">
                <label class="control-label"for="date">Data:</label>
                <input data-provide="datepicker" name="date" class="datepicker form-control w-auto" data-date-format="yyyy-mm-dd"
                       id="date" placeholder="Wybierz datę"
                       type="text" value="${expense.date}" autocomplete="off" required>
                <div class="valid-feedback">OK</div>
                <div class="invalid-feedback">Pole obowiązkowe</div>
            </div>
            <div class="form-group">
                <label for="name">Nazwa</label>
                <input type="text" class="form-control w-auto" id="name" placeholder="Wpisz nazwę wydatku"
                       name="name" value="${expense.name}" required>
                <div class="valid-feedback">OK</div>
                <div class="invalid-feedback">Pole obowiązkowe</div>
            </div>

            <div class="form-group">
                <label for="cost">Kwota wydatku</label>
                <input type="number" step="0.01" min=0  name="cost" class="form-control w-auto"
                       id="cost"
                       value = "${expense.cost}" required>
                <div class="valid-feedback">OK</div>
                <div class="invalid-feedback">Pole obowiązkowe</div>
            </div>


            <input type="hidden" name="id" value="${expense.id}">

            <button type="submit" class="btn btn-primary">Potwierdź</button>
        </form>
    </c:if>
</c:otherwise>
</c:choose>
</div

</body>
</html>
