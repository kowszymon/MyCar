<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2019-05-05
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Kategorie wydatków</title>
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



    <c:if test="${not empty expenseId}">
        <div class="alert alert-danger" role="alert">
                ${errorMsg} <a href=/expense?id=${expenseId}>Edytuj ten wydatek</a>
        </div>
    </c:if>

<c:choose>
    <c:when test="${not empty expenses}">
            <div class="alert alert-danger" role="alert">
                    ${errorMsg}
            </div>
        <div class="container w-auto">
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
            <c:forEach items="${expenses}" var="expense">
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
        </div>
    </c:when>
    <c:otherwise>

        <div class="container">


            <h2>Lista kategorii wydatków</h2>
    <table class="table table-dark table-striped w-auto">
        <thead>
        <tr>
            <th>Nazwa kategorii</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categoriesModel}" var="category">
            <tr>
                <td>${category.name}</td>
                 <td><a class="text-white" href="/category?id=${category.id}"><span title="Edytuj"><i class="far fa-edit"></i></span></a></td>
                <td><a class="text-white" href="/category/delete?id=${category.id}"
                       onclick="return confirm('Czy na pewno chcesz usunąć tę kategorię?');">
                    <span title="Usuń"><i class="fas fa-trash-alt"></i></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h4><a href="/category/add">Dodaj kategorię</a></h4>
</div>
</c:otherwise>
    </c:choose>


</body>
</html>
