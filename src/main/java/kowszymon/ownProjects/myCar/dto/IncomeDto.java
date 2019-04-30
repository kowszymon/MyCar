package kowszymon.ownProjects.myCar.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class IncomeDto {


    Long id;

    BigDecimal amount;

    LocalDate date;

    public IncomeDto(Long id, BigDecimal amount, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.date = date;
    }

    public IncomeDto(BigDecimal amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public IncomeDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeDto incomeDto = (IncomeDto) o;
        return id.equals(incomeDto.id) &&
                amount.equals(incomeDto.amount) &&
                date.equals(incomeDto.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, date);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
