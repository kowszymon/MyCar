package kowszymon.ownProjects.myCar.controllers.carControllers;

import kowszymon.ownProjects.myCar.dto.CarDto;
import kowszymon.ownProjects.myCar.entities.Fuel;
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

@WebServlet(name = "carSaveController", value = "/car/save")
public class CarSaveController extends HttpServlet {

    CarService carService = new CarServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String make = req.getParameter("make");
        String model = req.getParameter("model");
        String fuel = req.getParameter("fuel");
        String fuelConsumption = req.getParameter("fuelConsumptionPer100km");
        String course = req.getParameter("course");

        Long carId = null;
        try {
            carId = Long.valueOf(id);
        } catch (NumberFormatException e) {
           e.getMessage();
        }

        double carFuelConsumption = 0.0;
        try {
            carFuelConsumption = Double.valueOf(fuelConsumption);
        } catch (NumberFormatException e) {
            e.getMessage();
        }

        int carCourse = 0;
        try {
            carCourse = Integer.valueOf(course);
        } catch (NumberFormatException e) {
            e.getMessage();
        }


        if(name == null || "".equals(name)) {
            req.setAttribute("errorMsg", "Pole nazwa jest obowiązkowe!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/cars_jsp/car.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            CarDto formCarDto = new CarDto();
            formCarDto.setId(carId);
            formCarDto.setName(name);
            formCarDto.setMake(make);
            formCarDto.setModel(model);

            if(!"".equals(fuel)) {
                formCarDto.setFuel(fuel);
            }
            formCarDto.setFuelConsumptionPer100km(carFuelConsumption);
            formCarDto.setCourse(carCourse);
            carService.save(formCarDto);
            resp.sendRedirect("/car/list");
        }


    }
}
