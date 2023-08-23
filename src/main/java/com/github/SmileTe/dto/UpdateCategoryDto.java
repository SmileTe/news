package com.github.SmileTe.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;

public class UpdateCategoryDto {
    @Nullable
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
