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
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="icon" href="https://img.icons8.com/ios/50/000000/people-in-car-filled.png">
</head>
<body>
<jsp:include page="/myCar_jsp/nav.jsp"/>

<div class="container">
    <h2>Lista Twoich wydatków</h2>
    <table class="table table-dark table-striped w-auto">
        <thead>
        <tr>
            <th>Samochód</th>
            <th>Kategoria</th>
            <th>Data</th>
            <th>Nazwa</th>
            <th>Kwota</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${expensesModel}" var="expense">
            <tr>
                <td>${expense.carDto.name}</td>
                <td>${expense.categoryDto.name}</td>
                <td>${expense.date}</td>
                <td>${expense.name}</td>
                <td>${expense.cost}</td>
                <td><a class="text-white" href="/expense?id=${expense.id}"><span title="Edytuj"><i class="far fa-edit"></i></span></a></td>
                <td><a class="text-white" href="/expense/delete?id=${expense.id}"
                       onclick="return confirm('Czy na pewno chcesz usunąć ten wydatek?');">
                    <span title="Usuń"><i class="fas fa-trash-alt"></i></span></a></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h4><a href="/expense/add">Dodaj wydatek</a></h4>
</div>

</body>
</html>
