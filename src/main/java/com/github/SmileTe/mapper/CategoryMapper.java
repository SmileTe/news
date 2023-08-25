package com.github.SmileTe.mapper;

import com.github.SmileTe.dto.*;
import com.github.SmileTe.entity.Category;

import com.github.SmileTe.entity.Feed;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    @Mapping(source = "name",target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patch(@MappingTarget Category target, UpdateCategoryDto source);

    @Mapping(source = "name",target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void create(@MappingTarget Category target, CreateCategoryDto source);

    List<CategoryDto> listCategoryToCategoryDTO(List<Category> category);
    CategoryDto toDto(Category category);
}
