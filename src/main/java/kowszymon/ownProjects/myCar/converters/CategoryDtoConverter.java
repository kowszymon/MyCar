package kowszymon.ownProjects.myCar.converters;

import kowszymon.ownProjects.myCar.dto.CategoryDto;
import kowszymon.ownProjects.myCar.entities.Category;

import java.util.function.Function;

public class CategoryDtoConverter implements Function<Category, CategoryDto> {


    @Override
    public CategoryDto apply(Category category) {
        return new CategoryDto(category.getId(), category.getName());
    }
}
