package kowszymon.ownProjects.myCar.controllers.categoryControllers;

import kowszymon.ownProjects.myCar.dto.CategoryDto;
import kowszymon.ownProjects.myCar.exceptions.CategoryNotFoundException;
import kowszymon.ownProjects.myCar.services.CategoryService;
import kowszymon.ownProjects.myCar.services.CategoryServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "categoryEditController", value = "/category")
public class CategoryEditController extends HttpServlet {

    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Long categoryId = Long.valueOf(id);

        try {
            CategoryDto categoryDto = categoryService.findCategoryById(categoryId);
            req.setAttribute("category", categoryDto);
        } catch (CategoryNotFoundException e) {
            req.setAttribute("errorMsg", "Category with id " + id + " was not found");
        }

        req.setAttribute("AddOrEdit", "Edytuj kategorię");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/categories_jsp/category.jsp");
        requestDispatcher.forward(req, resp);
    }
}
