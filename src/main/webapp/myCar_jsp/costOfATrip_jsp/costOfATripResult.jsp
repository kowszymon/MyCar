<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2019-05-03
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Koszt przejazdu</title>
    <link rel="icon" href="https://img.icons8.com/ios/50/000000/people-in-car-filled.png">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="/myCar_jsp/nav.jsp"/>
<div>
    <c:choose>
        <c:when test="${not empty errorMsg}">
        <div class="alert alert-danger" role="alert">
                ${errorMsg}
            <a href="/car?id=${carIdToEdit}">Edytuj samochód</a>
        </div>
        <h4><a href="/costOfATrip"><-- wybierz inny samochód</a></h4>
        <h4><a href="/home"><-- powrót do menu</a></h4>
        </c:when>
        <c:otherwise>
    <h1>Obliczyliśmy koszt Twojego przejazdu.</h1>
    <br>
    <br>
    <br>
    <h4>Na tej trasie spalisz ${fuelConsumed} l ${fuel}.</h4>
    <br>
    <h4>Twój przejazd będzie kosztował <b>${costOfATripFull}
        <c:choose>
            <c:when test="${not empty singlePassenger}"> zł.</c:when>
            <c:otherwise>zł, a więc ${costOfATripPerPerson} zł na osobę.</c:otherwise>
        </c:choose>
    </b>
    </h4>
    <br>
    <h4>Miłej podróży!</h4>
    <br>
</div>
<div>
    <h6><a href = "/costOfATrip"> <-- oblicz koszt innego przejazdu</a></h6>
    <br>
    <br>
</div>
<div>
    <h6> Koszt został obliczony na podstawie aktualnych średnich cen paliw:</h6></h2>
    <table class="table w-auto table-bordered">
        <thead>
        <tr>
            <th>PB95</th>
            <th>PB98</th>
            <th>LPG</th>
            <th>ON</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${PB95Price} zł</td>
            <td>${PB98Price} zł</td>
            <td>${LPGPrice} zł</td>
            <td>${ONPrice} zł</td>
        </tr>
        </tbody>
    </table>
    <p><i> źródło: https://nafta.wnp.pl/ceny_paliw/</i></p>
    </c:otherwise>
    </c:choose>
</div>


</body>
</html>
