package kowszymon.ownProjects.myCar.controllers.costOfATripControllers;

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

@WebServlet(name = "costOfATripFormController", value = "/costOfATrip")
public class CostOfATripFormController extends HttpServlet {

    private CarService carService = new CarServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<CarDto> cars = carService.findActiveCars();
        req.setAttribute("carsModel", cars);

        if(cars.isEmpty()) {
            req.setAttribute("errorMsg", "Nie dodałeś do swojej bazy żadnego samochodu. " +
                    "Zrób to, aby móc sprawdzić koszt przejazdu. Pamiętaj, aby ustawić mu spalanie i paliwo.");
        }
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("/myCar_jsp/costOfATrip_jsp/costOfATripForm.jsp");
            requestDispatcher.forward(req, resp);


    }
}
