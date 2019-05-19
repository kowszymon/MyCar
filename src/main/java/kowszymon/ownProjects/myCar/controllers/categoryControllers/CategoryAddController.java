package kowszymon.ownProjects.myCar.controllers.categoryControllers;

import kowszymon.ownProjects.myCar.dto.CategoryDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "categoryAddController", value = "/category/add")
public class CategoryAddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("category", new CategoryDto());

        req.setAttribute("AddOrEdit", "Dodaj kategorię");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/categories_jsp/category.jsp");
        requestDispatcher.forward(req, resp);
    }
}
