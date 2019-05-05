package kowszymon.ownProjects.myCar.controllers.incomeControllers;

import kowszymon.ownProjects.myCar.dto.IncomeDto;
import kowszymon.ownProjects.myCar.exceptions.IncomeNotFoundException;
import kowszymon.ownProjects.myCar.services.IncomeService;
import kowszymon.ownProjects.myCar.services.IncomeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "incomeEditController", value = "/income")
public class IncomeEditController extends HttpServlet {

    private IncomeService incomeService = new IncomeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Long incomeId = Long.valueOf(id);

        try {
            IncomeDto incomeDto = incomeService.findIncomeById(incomeId);
            req.setAttribute("income", incomeDto);
        } catch (IncomeNotFoundException e) {
            req.setAttribute("errorMsg", "Przychód o id=" + id + " nie został znaleziony");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/incomes_jsp/income.jsp");
        requestDispatcher.forward(req, resp);
    }
}
