package kowszymon.ownProjects.myCar.controllers.carControllers;

import kowszymon.ownProjects.myCar.dto.CarDto;
import kowszymon.ownProjects.myCar.entities.Fuel;
import kowszymon.ownProjects.myCar.exceptions.CarNotFoundException;
import kowszymon.ownProjects.myCar.services.CarService;
import kowszymon.ownProjects.myCar.services.CarServiceImpl;

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

@WebServlet(name = "carEditController", value = "/car")
public class CarEditController extends HttpServlet {

    CarService carService = new CarServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Long carId = Long.valueOf(id);

        List<Fuel> fuelTypes = new ArrayList<>(Arrays.asList(Fuel.values()));

        req.setAttribute("fuelTypes", fuelTypes);





        try {
            CarDto carDto = carService.findCarById(carId);
            req.setAttribute("car", carDto);
            if(carDto.getFuel() == null){
                req.setAttribute("selectedFuel", "");
            } else {
                req.setAttribute("selectedFuel", carDto.getFuel());
            }
        } catch (CarNotFoundException e) {
            req.setAttribute("errorMsg", "Samochód o id " + carId + " nie został znaleziony w bazie");
        }

        req.setAttribute("AddOrEdit", "Edytuj samochód");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/cars_jsp/car.jsp");
        requestDispatcher.forward(req, resp);
    }
}
