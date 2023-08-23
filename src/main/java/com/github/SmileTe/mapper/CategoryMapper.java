package com.github.SmileTe.mapper;

import com.github.SmileTe.dto.CategoryDto;
import com.github.SmileTe.dto.CreateCategoryDto;
import com.github.SmileTe.dto.CreateFeedDto;
import com.github.SmileTe.dto.UpdateCategoryDto;
import com.github.SmileTe.entity.Category;

import com.github.SmileTe.entity.Feed;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    @Mapping(source = "name",target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patch(@MappingTarget Category target, UpdateCategoryDto source);

    @Mapping(source = "name",target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void create(@MappingTarget Category target, CreateCategoryDto source);


    CategoryDto toDto(Category category);
}
