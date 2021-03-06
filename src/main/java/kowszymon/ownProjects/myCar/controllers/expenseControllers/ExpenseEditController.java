package kowszymon.ownProjects.myCar.controllers.expenseControllers;

import kowszymon.ownProjects.myCar.dto.CarDto;
import kowszymon.ownProjects.myCar.dto.CategoryDto;
import kowszymon.ownProjects.myCar.dto.ExpenseDto;
import kowszymon.ownProjects.myCar.exceptions.ExpenseNotFoundException;
import kowszymon.ownProjects.myCar.services.CarService;
import kowszymon.ownProjects.myCar.services.CategoryService;
import kowszymon.ownProjects.myCar.services.ExpenseService;
import kowszymon.ownProjects.myCar.services.ExpenseServiceImpl;
import kowszymon.ownProjects.myCar.services.CarServiceImpl;
import kowszymon.ownProjects.myCar.services.CategoryServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "expenseEditController", value = "/expense")
public class ExpenseEditController extends HttpServlet {

    private ExpenseService expenseService = new ExpenseServiceImpl();
    private CarService carService = new CarServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Long expenseId = Long.valueOf(id);

        try {
            ExpenseDto expenseDto = expenseService.findExpenseById(expenseId);
            req.setAttribute("expense", expenseDto);
        } catch (ExpenseNotFoundException e) {
            req.setAttribute("errorMsg", "Wydatek o id=" + id + " nie został znaleziony");
        }

        List<CarDto> cars = carService.findCars();
        req.setAttribute("carsModel", cars);

        List<CategoryDto> categories = categoryService.findCategories();
        req.setAttribute("categoriesModel", categories);

        req.setAttribute("AddOrEdit", "Edytuj wydatek");


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/expenses_jsp/expense.jsp");
        requestDispatcher.forward(req, resp);

    }
}
