package kowszymon.ownProjects.myCar.controllers.expenseControllers;

import kowszymon.ownProjects.myCar.dto.CarDto;
import kowszymon.ownProjects.myCar.dto.CategoryDto;
import kowszymon.ownProjects.myCar.dto.ExpenseDto;
import kowszymon.ownProjects.myCar.services.CarService;
import kowszymon.ownProjects.myCar.services.CarServiceImpl;
import kowszymon.ownProjects.myCar.services.CategoryService;
import kowszymon.ownProjects.myCar.services.CategoryServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "expenseAddController", value = "/expense/add")
public class ExpenseAddController extends HttpServlet {

    private CarService carService = new CarServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("expense", new ExpenseDto());

        List<CarDto> cars = carService.findActiveCars();
        req.setAttribute("carsModel", cars);



        List<CategoryDto> categories = categoryService.findCategories();
        req.setAttribute("categoriesModel", categories);

        if (cars.isEmpty() && categories.isEmpty()) {
            req.setAttribute("errorMsgNoCarAndCategory", "Nie dodałeś do swojej bazy żadnego samochodu ani kategorii. " +
                    "Zrób to, aby móc dodać wydatek.");

        } else if (cars.isEmpty()) {
            req.setAttribute("errorMsgNoCar", "Nie dodałeś do swojej bazy żadnego samochodu. " +
                    "Zrób to, aby móc dodać wydatek.");

        } else if (categories.isEmpty()) {
            req.setAttribute("errorMsgNoCategory", "Nie dodałeś do swojej bazy żadnej kategorii. " +
                    "Zrób to, aby móc dodać wydatek.");

        }

        req.setAttribute("AddOrEdit", "Dodaj wydatek");



        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/expenses_jsp/expense.jsp");

        requestDispatcher.forward(req, resp);






    }
}
