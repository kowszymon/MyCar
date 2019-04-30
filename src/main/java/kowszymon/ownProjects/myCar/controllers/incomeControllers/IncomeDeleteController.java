package kowszymon.ownProjects.myCar.controllers.incomeControllers;

import kowszymon.ownProjects.myCar.services.IncomeService;
import kowszymon.ownProjects.myCar.services.IncomeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "incomeDeleteController", value = "/income/delete")
public class IncomeDeleteController extends HttpServlet {

    IncomeService incomeService = new IncomeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Long incomeId = Long.valueOf(id);
        incomeService.delete(incomeId);
        resp.sendRedirect("/income/list");
    }
}
