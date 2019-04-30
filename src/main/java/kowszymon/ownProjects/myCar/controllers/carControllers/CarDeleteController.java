package kowszymon.ownProjects.myCar.controllers.carControllers;

import kowszymon.ownProjects.myCar.services.CarService;
import kowszymon.ownProjects.myCar.services.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "carDeleteController", value = "/car/delete")
public class CarDeleteController extends HttpServlet {

    CarService carService = new CarServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        carService.delete(Long.valueOf(id));

        resp.sendRedirect("/car/list");
    }
}
