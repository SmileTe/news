package com.github.SmileTe.dto;

import com.github.SmileTe.entity.Category;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Date;

public class UpdateFeedDto {
    //все поля nullable, но если не null, то надо провалидировать
    @Nullable
    private  String name;
    @Nullable
    private String content;
    @Nullable
    private LocalDateTime data_publication;
    @Nullable
    private Category category;

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDataPublication() {
        return data_publication;
    }

    public Category getCategory() {
        return category;
    }

}
