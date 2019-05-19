package kowszymon.ownProjects.myCar.controllers.carControllers;

import kowszymon.ownProjects.myCar.dto.CarDto;
import kowszymon.ownProjects.myCar.entities.Fuel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "carAddController", value = "/car/add")
public class CarAddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("car", new CarDto());

        List<Fuel> fuelTypes = new ArrayList<>(Arrays.asList(Fuel.values()));

        req.setAttribute("fuelTypes", fuelTypes);

        req.setAttribute("selectedFuel", "");

        req.setAttribute("AddOrEdit", "Dodaj samochód");


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/cars_jsp/car.jsp");
        requestDispatcher.forward(req, resp);
    }
}
