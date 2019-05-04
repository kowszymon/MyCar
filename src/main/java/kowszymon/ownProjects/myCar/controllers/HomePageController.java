package kowszymon.ownProjects.myCar.controllers;

import kowszymon.ownProjects.myCar.services.BudgetService;
import kowszymon.ownProjects.myCar.services.BudgetServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "homePageController", value = "/home")
public class HomePageController extends HttpServlet {

    private BudgetService budgetService = new BudgetServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        BigDecimal budgetCount = budgetService.budgetCount();
//
//        req.setAttribute("budgetCount", budgetCount);

        RequestDispatcher requestDispatcher =req.getRequestDispatcher("/myCar_jsp/home_page.jsp");
        requestDispatcher.forward(req,resp);
    }
}
