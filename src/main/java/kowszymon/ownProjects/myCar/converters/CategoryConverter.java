package kowszymon.ownProjects.myCar.converters;

import kowszymon.ownProjects.myCar.dto.CategoryDto;
import kowszymon.ownProjects.myCar.entities.Category;

import java.util.function.Function;

public class CategoryConverter implements Function<CategoryDto, Category> {
    @Override
    public Category apply(CategoryDto categoryDto) {
        Category category = new Category();

        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());

        return category;
    }
}
