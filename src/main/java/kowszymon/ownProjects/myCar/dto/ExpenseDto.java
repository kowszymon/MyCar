package kowszymon.ownProjects.myCar.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseDto {

    private Long id;

    private String name;

    private CategoryDto categoryDto;

    private LocalDate date;

    private BigDecimal cost;

    private CarDto carDto;

    public CarDto getCarDto() {
        return carDto;
    }

    public void setCarDto(CarDto carDto) {
        this.carDto = carDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExpenseDto(Long id, String name, LocalDate date, BigDecimal cost) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }


    public ExpenseDto() {
    }

    public ExpenseDto(Long id, String name, CategoryDto categoryDto, LocalDate date, BigDecimal cost, CarDto carDto) {
        this.id = id;
        this.name = name;
        this.categoryDto = categoryDto;
        this.date = date;
        this.cost = cost;
        this.carDto = carDto;
    }

    public ExpenseDto(String name, CategoryDto categoryDto, LocalDate date, BigDecimal cost, CarDto carDto) {
        this.name = name;
        this.categoryDto = categoryDto;
        this.date = date;
        this.cost = cost;
        this.carDto = carDto;
    }
}
