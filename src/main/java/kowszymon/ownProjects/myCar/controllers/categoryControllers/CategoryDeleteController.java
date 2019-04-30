package kowszymon.ownProjects.myCar.controllers.categoryControllers;

import kowszymon.ownProjects.myCar.services.CategoryService;
import kowszymon.ownProjects.myCar.services.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "categoryDeleteController", value = "/category/delete/")
public class CategoryDeleteController extends HttpServlet {

    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        categoryService.delete(Long.valueOf(id));

        resp.sendRedirect("/category/list");
    }
}
