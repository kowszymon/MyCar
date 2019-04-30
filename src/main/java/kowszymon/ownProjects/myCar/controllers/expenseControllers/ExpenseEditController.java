package kowszymon.ownProjects.myCar.controllers.expenseControllers;

import kowszymon.ownProjects.myCar.dto.ExpenseDto;
import kowszymon.ownProjects.myCar.exceptions.ExpenseNotFoundException;
import kowszymon.ownProjects.myCar.services.ExpenseService;
import kowszymon.ownProjects.myCar.services.ExpenseServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "expenseEditController", value = "/expense")
public class ExpenseEditController extends HttpServlet {

    private ExpenseService expenseService = new ExpenseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Long expenseId = Long.valueOf(id);

        try {
            ExpenseDto expenseDto = expenseService.findExpenseById(expenseId);
            req.setAttribute("expense", expenseDto);
        } catch (ExpenseNotFoundException e) {
            req.setAttribute("errorMsg", "Expense with id=" + id + " was not found");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/expenses_jsp/expense.jsp");
        requestDispatcher.forward(req, resp);

    }
}
