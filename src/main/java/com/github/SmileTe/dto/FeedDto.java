package com.github.SmileTe.dto;

public class FeedDto {
    private long id;
    private String name;
    private String content;
    private String data_publication;
    //private CategoryDto category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getData_publication() {
        return data_publication;
    }

    public void setData_publication(String data_publication) {
        this.data_publication = data_publication;
    }

    @Override
    public String toString() {
        return "FeedDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", data_publication='" + data_publication + '\'' +
                '}';
    }
}
