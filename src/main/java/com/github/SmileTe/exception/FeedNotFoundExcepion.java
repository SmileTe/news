package com.github.SmileTe.exception;

public class FeedNotFoundExcepion extends RuntimeException{
    private final long id;

    public FeedNotFoundExcepion(long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Новость с id = " + id + " не найдена!";
    }
}
