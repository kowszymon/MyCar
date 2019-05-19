<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2019-04-28
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
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

    <c:if test="${not empty category}">
        <form action="/category/save" method ="post" class="was-validated">
            <div class="form-group">
                <label for="name">Nazwa:</label>
                <input type="text" class="form-control w-auto" id="name" placeholder="Wpisz nazwę kategorii"
                       name="name" value="${category.name}" autocomplete="off" required>
                <div class="valid-feedback">OK</div>
                <div class="invalid-feedback">Pole obowiązkowe</div>
            </div>

            <input type="hidden" name="id" value="${category.id}">

            <button type="submit" class="btn btn-primary">Potwierdź</button>
        </form>
    </c:if>
</div>
</body>
</html>
