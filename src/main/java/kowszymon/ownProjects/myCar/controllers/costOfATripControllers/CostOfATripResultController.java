package kowszymon.ownProjects.myCar.controllers.costOfATripControllers;

import kowszymon.ownProjects.myCar.dto.CarDto;
import kowszymon.ownProjects.myCar.exceptions.CarNotFoundException;
import kowszymon.ownProjects.myCar.services.CarService;
import kowszymon.ownProjects.myCar.services.CarServiceImpl;
import kowszymon.ownProjects.myCar.services.CountCostOfATripService;
import kowszymon.ownProjects.myCar.services.FuelPricesService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "costOfATripController", value = "/costOfATrip/result")
public class CostOfATripResultController extends HttpServlet {

    private CountCostOfATripService countCostOfATripService = new CountCostOfATripService();
    private CarService carService = new CarServiceImpl();
    private FuelPricesService fuelPricesService = new FuelPricesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String carId = req.getParameter("carId");
        String passengersQty = req.getParameter("passengersQty");
        String tripLength = req.getParameter("tripLength");

        Long carIdLong = null;
        try {
            carIdLong = Long.valueOf(carId);
        } catch (NumberFormatException e) {
            e.getMessage();
        }


        CarDto carDto = null;

        try {
            carDto = carService.findCarById(carIdLong);
        } catch (CarNotFoundException e){
            req.setAttribute("errorMsg", "Samochod o id " + carId + " nie zostal znaleziony");
        }



        if(carDto.getFuel() == null || carDto.getFuelConsumptionPer100km() == 0.0){
            req.setAttribute("carIdToEdit", carIdLong);
            req.setAttribute("errorMsg", "Samochodowi " + carDto.getName() + " nie przypisano rodzaju" +
                    " paliwa i/lub spalania.");
        } else {

            String fuel = carDto.getFuel();

            req.setAttribute("fuel", fuel);


            int passengersQtyInteger = Integer.parseInt(passengersQty);

            int tripLengthInteger = Integer.parseInt(tripLength);

            double fuelConsumed = carDto.getFuelConsumptionPer100km() * tripLengthInteger / 100;

            String fuelConsumedString = String.valueOf(fuelConsumed).replace('.', ',');

            req.setAttribute("fuelConsumed", fuelConsumedString);

            double costOfATripPerPerson = 0.0;

            try {
                costOfATripPerPerson = countCostOfATripService.countCostOfATrip(tripLengthInteger, carDto, passengersQtyInteger);
                costOfATripPerPerson = Math.round(costOfATripPerPerson* 100.0) / 100.0;
            } catch (IOException e) {
                e.getMessage();
            }

            double costOfATripFull = Math.round((costOfATripPerPerson * passengersQtyInteger) * 100.0) / 100.0;

            String costOfATripPerPersonString = String.valueOf(costOfATripPerPerson).replace('.', ',');

            String costOfATripFullString = String.valueOf(costOfATripFull).replace('.', ',');

            req.setAttribute("costOfATripPerPerson",costOfATripPerPersonString);
            req.setAttribute("costOfATripFull",costOfATripFullString);

            if(passengersQtyInteger == 1) {
                req.setAttribute("singlePassenger", true);
            }

            double PB95Price = Math.round(fuelPricesService.getAveragePB95Price() * 100.0) / 100.0;
            double PB98Price = Math.round(fuelPricesService.getAveragePB98Price() * 100.0) / 100.0;
            double LPGPrice = Math.round(fuelPricesService.getAverageLPGPrice() * 100.0) / 100.0;
            double ONPrice = Math.round(fuelPricesService.getAverageONPrice() * 100.0) / 100.0;

            String PB95PriceString = String.valueOf(PB95Price).replace('.', ',');
            String PB98PriceString = String.valueOf(PB98Price).replace('.', ',');
            String LPGPriceString = String.valueOf(LPGPrice).replace('.', ',');
            String ONPriceString = String.valueOf(ONPrice).replace('.', ',');

            req.setAttribute("PB95Price", PB95PriceString);
            req.setAttribute("PB98Price", PB98PriceString);
            req.setAttribute("LPGPrice", LPGPriceString);
            req.setAttribute("ONPrice", ONPriceString);

        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myCar_jsp/costOfATrip_jsp/costOfATripResult.jsp");
        requestDispatcher.forward(req, resp);

    }
}
