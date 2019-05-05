<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2019-04-14
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MyCar - przychody</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="/myCar_jsp/nav.jsp"/>

<div class="container">
    <h2>Lista przychodów</h2>
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th>Data</th>
            <th>Kwota</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${incomesModel}" var="income">
            <tr>
                <td>${income.date}</td>
                <td>${income.amount}</td>
                <td><a href="/income?id=${income.id}">Edytuj</a></td>
                <td><a href="/income/delete?id=${income.id}">Usuń przychód</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h4><a href="/income/add">Dodaj przychód</a></h4>
</div>

</body>
</html>
