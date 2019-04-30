package kowszymon.ownProjects.myCar.controllers.expenseControllers;

import kowszymon.ownProjects.myCar.entities.Expense;
import kowszymon.ownProjects.myCar.services.CategoryService;
import kowszymon.ownProjects.myCar.services.CategoryServiceImpl;
import kowszymon.ownProjects.myCar.services.ExpenseService;
import kowszymon.ownProjects.myCar.services.ExpenseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "expenseDeleteController", value = "/expense/delete")
public class ExpenseDeleteController extends HttpServlet {


    private ExpenseService expenseService = new ExpenseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        expenseService.delete(Long.valueOf(id));

        resp.sendRedirect("/expense/list");


    }
}
