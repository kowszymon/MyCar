<%@ page import="kowszymon.ownProjects.myCar.services.BudgetService" %>
<%@ page import="kowszymon.ownProjects.myCar.services.BudgetServiceImpl" %>


<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2019-04-28
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
 <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <!-- Brand/logo -->
        <a class="navbar-brand" href="/home">
            MyCar
        </a>

        <!-- Links -->
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">Link 1</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link 2</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link 3</a>
            </li>
        </ul>
    </div>
    <div class="mx-auto order-0">
        <a class="navbar-brand mx-auto" href="#">Navbar 2</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <% BudgetService budgetService = new BudgetServiceImpl();
                    String budget = budgetService.budgetCount().toString().replace('.', ',');%>
                <a class="text" href="#">Budżet: <%=budget%> zł</a>
            </li>
            <li class="nav-item">
                <a class="fas fa-plus" href="#"></a>
            </li>

        </ul>
    </div>
</nav>

