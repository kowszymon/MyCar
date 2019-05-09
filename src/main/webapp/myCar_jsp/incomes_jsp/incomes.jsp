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
    <title>Lista przychodów</title>
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
                <td><a class="text-white" href="/income?id=${income.id}"><span title="Edytuj"><i class="far fa-edit"></i></span></a></td>
                <td><a class="text-white" href="/income/delete?id=${income.id}"><span title="Usuń"><i class="fas fa-trash-alt"></i></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h4><a href="/income/add">Dodaj przychód</a></h4>
</div>

</body>
</html>
