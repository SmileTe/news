package com.github.SmileTe.exception;

public class CategoryNotFoundExcepion  extends RuntimeException {
    private final long id;

    public CategoryNotFoundExcepion(long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Новость с id = " + id + " не найдена!";
    }
}
