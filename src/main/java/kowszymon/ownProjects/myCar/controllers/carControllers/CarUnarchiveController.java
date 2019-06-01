package kowszymon.ownProjects.myCar.controllers.carControllers;

import kowszymon.ownProjects.myCar.dto.CarDto;
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
import java.util.List;

@WebServlet(name = "carUnarchiveController", value = "/car/unarchive")
public class CarUnarchiveController extends HttpServlet {

    CarService carService = new CarServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try {
            CarDto carDto = carService.findCarById(Long.valueOf(id));
            carDto.setStatus("ACTIVE");
            carService.save(carDto);
            req.setAttribute("message", "Samochód " + carDto.getName() + " został przywrócony" );
        } catch (CarNotFoundException e) {
            req.setAttribute("errorMsg", e.getMessage());
        }

        List<CarDto> cars = carService.findActiveCars();

        req.setAttribute("carsModel", cars);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/cars_jsp/cars.jsp");
        requestDispatcher.forward(req, resp);
    }
}
