package kowszymon.ownProjects.myCar.converters;

import kowszymon.ownProjects.myCar.dto.CarDto;
import kowszymon.ownProjects.myCar.dto.ExpenseDto;
import kowszymon.ownProjects.myCar.entities.Car;
import kowszymon.ownProjects.myCar.entities.CarStatus;
import kowszymon.ownProjects.myCar.entities.Expense;
import kowszymon.ownProjects.myCar.entities.Fuel;

import java.util.function.Function;
import java.util.stream.Collectors;

public class CarConverter implements Function<CarDto, Car> {


    private Function<ExpenseDto, Expense> expenseConverter;



    @Override
    public Car apply(CarDto carDto) {

        if(expenseConverter == null){
            expenseConverter = new ExpenseConverter();
        }


        Car car = new Car();

        if(carDto.getFuel() != null){
        String fuel = carDto.getFuel();
        Fuel fuelEnum = Fuel.valueOf(fuel);
            car.setFuel(fuelEnum);}

        if(carDto.getStatus() != null){
            String status = carDto.getStatus();
            CarStatus statusEnum = CarStatus.valueOf(status);
            car.setStatus(statusEnum);}

        if(carDto.getId() != null) {
            car.setId(carDto.getId());
        }

        if(carDto.getName() != null) {
            car.setName(carDto.getName());
        }

        if(carDto.getMake() != null) {
            car.setMake(carDto.getMake());
        }

        if(carDto.getModel() != null) {
            car.setModel(carDto.getModel());
        }

        car.setCourse(carDto.getCourse());



        car.setFuelConsumptionPer100km(carDto.getFuelConsumptionPer100km());




        return car;
    }
}
