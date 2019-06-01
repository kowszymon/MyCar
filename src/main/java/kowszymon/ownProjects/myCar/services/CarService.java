package kowszymon.ownProjects.myCar.services;

import kowszymon.ownProjects.myCar.dto.CarDto;
import kowszymon.ownProjects.myCar.exceptions.CarNotFoundException;

import java.util.List;

public interface CarService {

    List<CarDto> findCars();

    List<CarDto> findActiveCars();

    List<CarDto> findArchivedCars();

    CarDto findCarById(Long carId) throws CarNotFoundException;

    void save(CarDto carDto);


}
