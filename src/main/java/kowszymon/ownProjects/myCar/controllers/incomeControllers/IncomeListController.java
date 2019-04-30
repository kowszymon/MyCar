package kowszymon.ownProjects.myCar.controllers.incomeControllers;

import kowszymon.ownProjects.myCar.dto.IncomeDto;
import kowszymon.ownProjects.myCar.services.IncomeService;
import kowszymon.ownProjects.myCar.services.IncomeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "incomeListController", value = "/income/list")
public class IncomeListController extends HttpServlet {

    private IncomeService incomeService = new IncomeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<IncomeDto> incomes = incomeService.findIncomes();

        req.setAttribute("incomesModel", incomes);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/incomes_jsp/incomes.jsp");
        requestDispatcher.forward(req, resp);
    }
}
