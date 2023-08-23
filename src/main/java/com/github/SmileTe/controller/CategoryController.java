package com.github.SmileTe.controller;

import com.github.SmileTe.dto.*;
import com.github.SmileTe.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
//@Tag()
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

//@PostMapping
    @Operation(summary = "...", description = "...",
                responses = {
                        @ApiResponse(responseCode = "200", description = "..."),
                        @ApiResponse(responseCode = "404", description = "..."),
                        @ApiResponse(responseCode = "400", description = "...")
    })
    @PatchMapping("{id}")
    public CategoryDto patch(@PathVariable("id") Long id,
                                 @RequestBody @Valid UpdateCategoryDto updateCategoryDto) {
        return categoryService.patch(id, updateCategoryDto);
    }


    @PostMapping
    public CategoryDto create(@RequestBody @Valid CreateCategoryDto createCategoryDto) {
        return categoryService.create(createCategoryDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
