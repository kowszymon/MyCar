package kowszymon.ownProjects.myCar.services;


import kowszymon.ownProjects.myCar.converters.CarConverter;
import kowszymon.ownProjects.myCar.converters.CarDtoConverter;
import kowszymon.ownProjects.myCar.dao.CarDao;
import kowszymon.ownProjects.myCar.dao.CarDaoImpl;
import kowszymon.ownProjects.myCar.dto.CarDto;
import kowszymon.ownProjects.myCar.entities.Car;
import kowszymon.ownProjects.myCar.exceptions.CarNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    private CarDao carDao = new CarDaoImpl();

    private CarDtoConverter carDtoConverter = new CarDtoConverter();

    private CarConverter carConverter = new CarConverter();


    @Override
    public List<CarDto> findCars() {
        List<Car> cars = carDao.findAll();
        return cars.stream()
                .map(carDtoConverter)
                .collect(Collectors.toList());
    }

    @Override
    public CarDto findCarById(Long carId) throws CarNotFoundException {
        Optional<Car> carOptional = carDao.findById(carId);

        if(carOptional.isPresent()) {
            Car car = carOptional.get();
            CarDto carDto = carDtoConverter.apply(car);
            return carDto;
        } else {
            throw new CarNotFoundException("Car with id " + carId + " was not found");
        }
    }

    @Override
    public void save(CarDto carDto) {
        Car car = carConverter.apply(carDto);
        carDao.save(car);
    }

    @Override
    public void delete(Long carId) {
        carDao.delete(carId);
    }
}
