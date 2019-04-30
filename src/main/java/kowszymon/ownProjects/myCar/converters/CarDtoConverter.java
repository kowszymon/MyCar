package kowszymon.ownProjects.myCar.converters;

import kowszymon.ownProjects.myCar.dto.CarDto;
import kowszymon.ownProjects.myCar.dto.ExpenseDto;
import kowszymon.ownProjects.myCar.entities.Car;
import kowszymon.ownProjects.myCar.entities.Expense;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CarDtoConverter implements Function<Car, CarDto> {

    private Function<Expense, ExpenseDto> expenseDtoConverter;

    @Override
    public CarDto apply(Car car) {

        if(expenseDtoConverter == null) {
            expenseDtoConverter = new ExpenseDtoConverter();
        }
        CarDto carDto = new CarDto();


        carDto.setId(car.getId());

        if(car.getName() != null) {
            carDto.setName(car.getName());
        }
        if(car.getMake() != null){
            carDto.setMake(car.getMake());

        }

        if(car.getModel() != null){
        carDto.setModel(car.getModel());
        }

        carDto.setCourse(car.getCourse());

        carDto.setFuelConsumptionPer100km(car.getFuelConsumptionPer100km());

        if(car.getFuel() != null) {
            carDto.setFuel(car.getFuel().name());
        }


        return carDto;
    }
}
