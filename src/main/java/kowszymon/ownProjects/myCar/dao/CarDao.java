package kowszymon.ownProjects.myCar.dao;

import kowszymon.ownProjects.myCar.entities.Car;

import java.util.List;
import java.util.Optional;

public interface CarDao {

    List<Car> findAll();

    List<Car> findActiveCars();

    List<Car> findArchivedCars();

    Optional<Car> findById(Long id);

    void save(Car car);

}
