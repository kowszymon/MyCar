package kowszymon.ownProjects.myCar.controllers.categoryControllers;

import kowszymon.ownProjects.myCar.dto.CategoryDto;
import kowszymon.ownProjects.myCar.services.CategoryService;
import kowszymon.ownProjects.myCar.services.CategoryServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "categorySaveController", value = "/category/save")
public class CategorySaveController extends HttpServlet {

    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");

        Long carId = null;

        try{
            carId = Long.valueOf(id);
        } catch (NumberFormatException e) {

        }

        if(name == null || "".equals(name)) {
            req.setAttribute("errorMsg", "Name should not be empty!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/categories_jsp/categories.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            CategoryDto formCategoryDto = new CategoryDto(carId, name);
            categoryService.save(formCategoryDto);
            resp.sendRedirect("/category/list");
        }


    }
}
