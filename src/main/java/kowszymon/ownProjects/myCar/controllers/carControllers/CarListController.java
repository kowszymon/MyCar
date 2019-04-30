package kowszymon.ownProjects.myCar.controllers.carControllers;


import kowszymon.ownProjects.myCar.dto.CarDto;
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

@WebServlet(name = "carListController", value = "/car/list")
public class CarListController extends HttpServlet {

    private CarService carService = new CarServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<CarDto> cars = carService.findCars();

        req.setAttribute("carsModel", cars);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/cars_jsp/cars.jsp");
        requestDispatcher.forward(req, resp);
    }
}
