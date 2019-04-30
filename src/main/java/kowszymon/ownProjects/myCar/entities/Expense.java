package kowszymon.ownProjects.myCar.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;


    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    Category category;

    @Column
    private LocalDate date;

    @Column
    private BigDecimal cost;


    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Car car;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate time) {
        this.date = time;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Expense() {
    }

    public Expense(String name, Category category, LocalDate date, BigDecimal cost, Car car) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.cost = cost;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", time=" + date +
                ", cost=" + cost +
                ", car=" + car +
                '}';
    }
}
