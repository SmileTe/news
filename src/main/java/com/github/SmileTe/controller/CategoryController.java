package com.github.SmileTe.controller;

import com.github.SmileTe.dto.*;
import com.github.SmileTe.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
//@Tag()
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

//@PostMapping
@Operation(summary = "Изменить существующую категорию",
        responses = {@ApiResponse(responseCode = "200", description = "Created"),
                @ApiResponse(responseCode = "404", description = "Not Found"),
                @ApiResponse(responseCode = "400", description = "Bad Request")

        },
        tags = "Categories")
    @PatchMapping("{id}")
    public CategoryDto patch(@PathVariable("id") Long id,
                                 @RequestBody @Valid UpdateCategoryDto updateCategoryDto) {
        return categoryService.patch(id, updateCategoryDto);
    }


    @PostMapping
    @Operation(summary = "Создать новую категорию",
            responses = {@ApiResponse(responseCode = "200", description = "Created"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "400", description = "Bad Request")
            },
            tags = "Categories")

    public CategoryDto create(@RequestBody @Valid CreateCategoryDto createCategoryDto) {
        return categoryService.create(createCategoryDto);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Удалить существующую категорию",
            responses = {@ApiResponse(responseCode = "200", description = "Created"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "400", description = "Bad Request")
            },
            tags = "Categories")

    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        boolean result = categoryService.delete(id);
        if (result) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping
    @Operation(summary = "Получить существующую категорию",
            responses = {@ApiResponse(responseCode = "200", description = "Created"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "400", description = "Bad Request")
            },
            tags = "Categories")
    public ResponseEntity<Iterable<CategoryDto>> findCategories(
            @RequestParam(required = false, name = "nameCategory") String nameCategory
    ) {
        return ResponseEntity.ok(categoryService.findCategories(nameCategory));
    }



}
