package kowszymon.ownProjects.myCar.controllers.expenseControllers;

import kowszymon.ownProjects.myCar.dto.ExpenseDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "expenseAddController", value = "/expense/add")
public class ExpenseAddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("expense", new ExpenseDto());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/expenses/expense.jsp");

        requestDispatcher.forward(req, resp);
    }
}
