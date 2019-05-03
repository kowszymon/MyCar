package kowszymon.ownProjects.myCar.services;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class FuelPricesServiceTest {

    FuelPricesService fuelPricesService = new FuelPricesService();


    @Test
    public void shouldReturnCurrentONPrice() {
        double result = 0.0;
        try{result = fuelPricesService.getAverageONPrice();}
        catch (IOException e){
            e.getMessage();
        }
        Assert.assertEquals(5.17, result, 0.01);
    }

    @Test
    public void shouldReturnCurrentPB95Price() {
        double result = 0.0;
        try{result = fuelPricesService.getAveragePB95Price();}
        catch (IOException e){
            e.getMessage();
        }
        Assert.assertEquals(5.20, result, 0.01);
    }

    @Test
    public void shouldReturnCurrentPB98Price() {
        double result = 0.0;
        try{result = fuelPricesService.getAveragePB98Price();}
        catch (IOException e){
            e.getMessage();
        }
        Assert.assertEquals(5.49, result, 0.01);
    }

    @Test
    public void shouldReturnCurrentLPGPrice() {
       double result = 0.0;
       try{result = fuelPricesService.getAverageLPGPrice();}
       catch (IOException e){
           e.getMessage();
       }
        Assert.assertEquals(2.25, result, 0.01);
    }



}