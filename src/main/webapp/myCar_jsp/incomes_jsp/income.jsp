<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2019-04-14
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj przychód</title>
    <link rel="icon" href="https://img.icons8.com/ios/50/000000/people-in-car-filled.png">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

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
    <h2>Edytuj przychód</h2>
    <c:if test="${not empty errorMsg}">
        <div class="alert alert-danger" role="alert">
                ${errorMsg}
        </div>
    </c:if>

    <c:if test="${not empty income}">
        <form action="/income/save" method ="post" class="was-validated">
            <input type="hidden" name="date" value="${date}">

            <div class="form-group">
                <label for="amount">Kwota</label>
                <input type="number" min=0 step=0.01 class="form-control w-auto" id="amount"
                       placeholder="Podaj kwotę" name="amount" value ="${income.amount}" autocomplete="off" required>
                <div class="valid-feedback">OK</div>
                <div class="invalid-feedback">Pole obowiązkowe</div>
            </div>
            <input type="hidden" name="id" value="${income.id}">

            <button type="submit" class="btn btn-primary">Potwierdź</button>
        </form>
    </c:if>
</div>



</body>
</html>
