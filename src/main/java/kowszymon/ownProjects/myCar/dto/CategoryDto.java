package kowszymon.ownProjects.myCar.dto;

public class CategoryDto {

    Long id;

    String name;

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

    public CategoryDto() {
    }

    public CategoryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
