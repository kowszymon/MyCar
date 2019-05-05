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

<div class="container">
    <h2>Lista kategorii wydatków</h2>
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th>Nazwa kategorii</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categoriesModel}" var="category">
            <tr>
                <td>${category.name}</td>
                 <td><a href="/category?id=${category.id}">Edytuj</a></td>
                <td><a href="/category/delete?id=${category.id}">Usuń</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h4><a href="/category/add">Dodaj kategorię</a></h4>
</div>


</body>
</html>
