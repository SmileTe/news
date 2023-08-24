package com.github.SmileTe.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "Дата обязательна")
    private String data_publication;
    @NotNull(message = "Надо указать категорию")
    private long category_id;

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

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }
}
