package kowszymon.ownProjects.myCar.controllers.categoryControllers;

import kowszymon.ownProjects.myCar.dto.CategoryDto;
import kowszymon.ownProjects.myCar.exceptions.CannotDeleteItemException;
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

@WebServlet(name = "categoryDeleteController", value = "/category/delete")
public class CategoryDeleteController extends HttpServlet {

    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        try {
            categoryService.delete(Long.valueOf(id));
        } catch (CannotDeleteItemException e) {
            req.setAttribute("errorMsg", e.getMessage());
            req.setAttribute("expenseId", e.getItemId());
            req.setAttribute("expenses", e.getExpenses());
        }

        List<CategoryDto> categories = categoryService.findCategories();
        req.setAttribute("categoriesModel", categories);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/categories_jsp/categories.jsp");
        requestDispatcher.forward(req, resp);
    }
}
