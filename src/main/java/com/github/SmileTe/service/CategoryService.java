package com.github.SmileTe.service;

import com.github.SmileTe.dto.*;
import com.github.SmileTe.entity.Category;
import com.github.SmileTe.entity.Feed;
import com.github.SmileTe.exception.CategoryNotFoundExcepion;
import com.github.SmileTe.exception.FeedNotFoundExcepion;
import com.github.SmileTe.mapper.CategoryMapper;
import com.github.SmileTe.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class CategoryService {
    public final CategoryRepository categoryRepository;
    public final CategoryMapper categoryMapper;

    public CategoryDto patch(Long id, UpdateCategoryDto updateCategoryDto) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundExcepion(id));
        categoryMapper.patch(category, updateCategoryDto);
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    public CategoryDto create(CreateCategoryDto createCategoryDto){
        Category category = new Category();
        categoryMapper.create(category, createCategoryDto);
        return  categoryMapper.toDto(categoryRepository.save(category));
    }

    public boolean  delete(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundExcepion(id));
        try {
        categoryRepository.delete(category);
        //categoryMapper.toDto(category);//!!!!м.б. лишнее
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    public List<CategoryDto> findCategories(String name){

        List<Category> categoryList = categoryRepository.findAllByName(name);
        List<CategoryDto> categoryDTOList = categoryMapper.listCategoryToCategoryDTO(categoryList);
        return categoryDTOList;
    }

}
