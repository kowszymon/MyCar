package kowszymon.ownProjects.myCar.dto;

import java.util.List;


public class CarDto {

    private Long id;

    private String name;

    private String make;

    private String model;

    private String fuel;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private double fuelConsumptionPer100km;

    private int course;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public double getFuelConsumptionPer100km() {
        return fuelConsumptionPer100km;
    }

    public void setFuelConsumptionPer100km(double fuelConsumptionPer100km) {
        this.fuelConsumptionPer100km = fuelConsumptionPer100km;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }


    public CarDto() {
    }

    public CarDto(Long id, String name, String make, String model, String fuel, double fuelConsumptionPer100km, int course) {
        this.id = id;
        this.name = name;
        this.make = make;
        this.model = model;
        this.fuel = fuel;
        this.fuelConsumptionPer100km = fuelConsumptionPer100km;
        this.course = course;
    }
}
