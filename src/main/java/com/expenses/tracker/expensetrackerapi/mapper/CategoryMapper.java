package com.expenses.tracker.expensetrackerapi.mapper;

import com.expenses.tracker.expensetrackerapi.dto.request.CategoryRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.response.CategoryResponseDto;
import com.expenses.tracker.expensetrackerapi.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements EntityMapper<Category, CategoryRequestDto, CategoryResponseDto> {
    @Override
    public Category toEntity(CategoryRequestDto dto) {
        var category = new Category();
        category.setName(dto.name());
        category.setDescription(dto.description());
        return category;
    }

    @Override
    public CategoryResponseDto toResponseDto(Category entity) {
        return new CategoryResponseDto(
                entity.getName(),
                entity.getDescription(),
                entity.getUser().getId(),
                entity.getCreatedDate(),
                entity.getLastModifiedDate(),
                entity.getCreatedBy(),
                entity.getLastModifiedBy(),
                entity.getIsActive(),
                entity.getVersion()
                );
    }
}
