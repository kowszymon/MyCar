package kowszymon.ownProjects.myCar.entities;


import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String make;

    @Column
    private String model;

    @Column
    @Enumerated(EnumType.STRING)
    private Fuel fuel;

    @Column
    private double fuelConsumptionPer100km;

    @Column
    private int course;

    @Column
    @Enumerated(EnumType.STRING)
    private CarStatus status;

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Car(String name, String make, String model, Fuel fuel, double fuelConsumptionPer100km, int course, CarStatus status) {
        this.name = name;
        this.make = make;
        this.model = model;
        this.fuel = fuel;
        this.fuelConsumptionPer100km = fuelConsumptionPer100km;
        this.course = course;
        this.status = status;
    }

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

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public double getFuelConsumptionPer100km() {
        return fuelConsumptionPer100km;
    }

    public void setFuelConsumptionPer100km(double fuelConsumptionPer100km) {
        this.fuelConsumptionPer100km = fuelConsumptionPer100km;
    }




    public Car() {
    }
}
