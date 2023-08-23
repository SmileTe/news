package com.github.SmileTe.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

public class CreateFeedDto {
    //все поля обязательны, валидация not null
    @NotBlank(message = "Название не может быть пустым")
    @Size(min = 3, max = 100)
    private String name;
    @Getter
    @NotBlank(message = "Содержание не может быть пустым")
    @Size(min = 3)
    private String content;
    //@NotBlank(message = "Дата обязательна")
    private String data_publication;
    //@NotBlank(message = "Надо выбрать категорию")
    //@JsonProperty("category")
    //private CategoryDto categoryDto;

    //@JsonProperty("category")
    private CreateCategoryDto categoryDto;

//    public static class CreateCategoryDto {
//        //private Long id;
//        private String name;
//
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }

//        public Long getId() {
//            return id;
//        }
//
//        public void setId(Long id) {
//            this.id = id;
//        }
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDataPublication() {
        return data_publication;
    }

    public void setDataPublication(String data_publication) {
        this.data_publication = data_publication;
    }

    public CreateCategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CreateCategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }
}
