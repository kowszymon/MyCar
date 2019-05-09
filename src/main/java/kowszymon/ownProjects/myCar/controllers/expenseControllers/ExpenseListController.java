package kowszymon.ownProjects.myCar.controllers.expenseControllers;

import kowszymon.ownProjects.myCar.dto.ExpenseDto;
import kowszymon.ownProjects.myCar.services.ExpenseService;
import kowszymon.ownProjects.myCar.services.ExpenseServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "expenseListController", value = "/expense/list")
public class ExpenseListController extends HttpServlet {

    private ExpenseService expenseService = new ExpenseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<ExpenseDto> expenses = expenseService.findExpenses();

        req.setAttribute("expensesModel", expenses);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/expenses_jsp/expenses.jsp");
        requestDispatcher.forward(req, resp);
    }
}
