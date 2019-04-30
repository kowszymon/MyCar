package kowszymon.ownProjects.myCar.services;

import kowszymon.ownProjects.myCar.dto.CarDto;
import kowszymon.ownProjects.myCar.exceptions.CarNotFoundException;

import java.util.List;

public interface CarService {

    List<CarDto> findCars();

    CarDto findCarById(Long carId) throws CarNotFoundException;

    void save(CarDto carDto);

    void delete(Long carId);


}
