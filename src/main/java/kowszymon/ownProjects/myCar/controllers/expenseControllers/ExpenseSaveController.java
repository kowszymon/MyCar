package kowszymon.ownProjects.myCar.controllers.expenseControllers;

import kowszymon.ownProjects.myCar.dto.CarDto;
import kowszymon.ownProjects.myCar.dto.CategoryDto;
import kowszymon.ownProjects.myCar.dto.ExpenseDto;
import kowszymon.ownProjects.myCar.entities.Expense;
import kowszymon.ownProjects.myCar.exceptions.CarNotFoundException;
import kowszymon.ownProjects.myCar.exceptions.CategoryNotFoundException;
import kowszymon.ownProjects.myCar.exceptions.NotEnoughBudgetException;
import kowszymon.ownProjects.myCar.services.*;

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

@WebServlet(name = "expenseSaveController", value = "/expense/save")
public class ExpenseSaveController extends HttpServlet {

    private ExpenseService expenseService = new ExpenseServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();
    private CarService carService = new CarServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String expenseId = req.getParameter("ExpenseId");
        String name = req.getParameter("name");
        String date = req.getParameter("date");
        String cost = req.getParameter("cost");

        String categoryId = req.getParameter("categoryId");
        String carId = req.getParameter("carId");

        Long expenseIdLong = null;

        try {
            expenseIdLong = Long.valueOf(expenseId);
        } catch (NumberFormatException e) {
            req.setAttribute("errorMsg", "Wrong format of id number");
        }


        LocalDate expenseDate = null;

        try {
            expenseDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeException e){
            req.setAttribute("errorMsg", "Problem with parsing date");
        }


        BigDecimal expenseCostBigDecimal = null;

        try {
            expenseCostBigDecimal = BigDecimal.valueOf(Double.valueOf(cost));
        } catch (NumberFormatException e) {
            req.setAttribute("errorMsg", "Wrong format of expense cost");
        }

        Long categoryIdLong = Long.valueOf(categoryId);
        CategoryDto categoryDto = null;

        try {
            categoryDto = categoryService.findCategoryById(categoryIdLong);
        } catch (CategoryNotFoundException e) {
            req.setAttribute("errorMsg", "Category with id " + categoryId + " was not found");
        }


        Long carIdLong = Long.valueOf(carId);
        CarDto carDto = null;

        try {
            carDto = carService.findCarById(carIdLong);
        } catch (CarNotFoundException e) {
            req.setAttribute("errorMsg", "Car with id " + carId + " was not found");
        }

        if(date == null || "".equals(date) || name == null || "".equals(name) || cost == null || "".equals(cost)) {
            req.setAttribute("errorMsg", "Date, name and cost cannot be empty!");
        } else {
            ExpenseDto formExpenseDto = new ExpenseDto(expenseIdLong, name, categoryDto,
                    expenseDate, expenseCostBigDecimal, carDto);
            try {
                expenseService.save(formExpenseDto);
            } catch (NotEnoughBudgetException e){
                req.setAttribute("errorMsg", "Nie posiadasz wystarczającego budżetu na ten wydatek!");
            }
        }




    }
}
