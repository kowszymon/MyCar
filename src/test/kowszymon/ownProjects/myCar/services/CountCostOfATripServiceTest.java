package kowszymon.ownProjects.myCar.services;

import kowszymon.ownProjects.myCar.dto.CarDto;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class CountCostOfATripServiceTest {

    FuelPricesService fuelPricesService = new FuelPricesService();

    CountCostOfATripService countCostOfATripService = new CountCostOfATripService();
    CarDto carDto = new CarDto();

    @Test
    public void countCostOfATrip() {
        carDto.setFuelConsumptionPer100km(10.0);
        carDto.setFuel("LPG");

        double result = 0.0;

        try {
           result = countCostOfATripService.countCostOfATrip(160, carDto, 4);
        } catch (IOException e){
            e.getMessage();
        }

        Assert.assertEquals(9.00, result, 0.01);

    }
}