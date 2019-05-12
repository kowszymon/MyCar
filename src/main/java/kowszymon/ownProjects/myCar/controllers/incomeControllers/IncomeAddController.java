package kowszymon.ownProjects.myCar.controllers.incomeControllers;

import kowszymon.ownProjects.myCar.dto.IncomeDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "incomeAddController", value = "/income/add")
public class IncomeAddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("income", new IncomeDto());

        req.setAttribute("date", LocalDate.now());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/incomes_jsp/income.jsp");
        requestDispatcher.forward(req, resp);
    }
}
