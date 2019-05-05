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
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.function.DoubleBinaryOperator;

@WebServlet(name = "incomeSaveController", value = "/income/save")
public class IncomeSaveController extends HttpServlet {

    private IncomeService incomeService = new IncomeServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String date = req.getParameter("date");
        String amount = req.getParameter("amount");

        Long incomeId = null;
        try {
            incomeId = Long.valueOf(id);
        } catch (NumberFormatException e) {

        }

        LocalDate incomeDate = null;

        try {
            incomeDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeException e){
            e.getMessage();
        }


        BigDecimal incomeAmount = null;

        try {
            incomeAmount = BigDecimal.valueOf(Double.valueOf(amount));
        } catch (NumberFormatException e) {

        }

        if(date == null || "".equals(date) || amount == null || "".equals(amount)) {
            req.setAttribute("errorMsg", "Pola data i kwota nie mogą być puste.");
            req.setAttribute("income", new IncomeDto());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/incomes_jsp/income.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            IncomeDto formIncomeDto = new IncomeDto(incomeId, incomeAmount, incomeDate);
            incomeService.save(formIncomeDto);
            resp.sendRedirect("/income/list");
        }


    }
}
