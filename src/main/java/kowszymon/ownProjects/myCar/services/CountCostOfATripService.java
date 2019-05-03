package kowszymon.ownProjects.myCar.services;

import kowszymon.ownProjects.myCar.dto.CarDto;

import java.io.IOException;

public class CountCostOfATripService {

   private FuelPricesService fuelPricesService = new FuelPricesService();


    public double countCostOfATrip(int tripLength, CarDto carDto, int passengersQty) throws IOException {

        double costOfATrip = 0.0;


        switch (carDto.getFuel()){
            case "PB95":
                double PB95Price = fuelPricesService.getAveragePB95Price();
                costOfATrip = carDto.getFuelConsumptionPer100km() * tripLength / 100 * PB95Price / passengersQty;
                return Math.round(costOfATrip * 100.0) / 100.0;

            case "PB98":
                double PB98Price = fuelPricesService.getAveragePB98Price();
                costOfATrip = carDto.getFuelConsumptionPer100km() * tripLength / 100.0 * PB98Price / passengersQty;
                return Math.round(costOfATrip * 100.0) / 100.0;

            case "LPG":
                double LPGPrice = fuelPricesService.getAverageLPGPrice();
                costOfATrip = carDto.getFuelConsumptionPer100km() * tripLength / 100.0 * LPGPrice / passengersQty;
                return Math.round(costOfATrip * 100.0) / 100.0;

            case "ON":
                double ONPrice = fuelPricesService.getAverageONPrice();
                costOfATrip = carDto.getFuelConsumptionPer100km() * tripLength / 100 * ONPrice / passengersQty;
                return Math.round(costOfATrip * 100.0) / 100.0;
        }

        return costOfATrip;
    }
}
