<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2019-04-11
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MyCar - Home page</title>
    <link rel="icon" href="https://img.icons8.com/ios/50/000000/people-in-car-filled.png">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
</head>
<body>
<jsp:include page="nav.jsp"/>

<div class="album py-5 bg-light">
    <div class="container">

        <div class="row">
            <div class="col-sm-12 col-md-3 text-center">
                <div class="card mb-4 box-shadow">
                    <a href="#"><i class="fas fa-money-bill-alt fa-10x"></i></a>
                    <div class="card-body">
                        <a href="/expense/list"><h2>Wydatki</h2></a>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-md-3 text-center">
                <div class="card mb-4 box-shadow">
                    <a href="/costOfATrip"><i class="fas fa-road fa-10x"></i></a>
                    <div class="card-body">
                        <a href="/costOfATrip"><h2>Sprawdź koszt przejazdu</h2></a>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-md-3 text-center">
                <div class="card mb-4 box-shadow">
                    <a href="/car/list"><i class="fas fa-car fa-10x"></i></a>
                    <div class="card-body">
                        <a href="/car/list"><h2>Moje samochody</h2></a>
                    </div>
                </div>
            </div>

            <div class="col-sm-12 col-md-3 text-center">
                <div class="card mb-4 box-shadow">
                    <a href="#"><i class="fas fa-question fa-10x"></i></a>
                    <div class="card-body">
                        <a href="#"><h2>Coś tam</h2></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
