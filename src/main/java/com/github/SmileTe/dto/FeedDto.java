package com.github.SmileTe.dto;

import java.time.LocalDateTime;

public class FeedDto {
    private long id;
    private String name;
    private String content;
    private LocalDateTime data_publication;
    //private CategoryDto category;

   // private CategoryDto category;




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

    public LocalDateTime getData_publication() {
        return data_publication;
    }

    public void setData_publication(LocalDateTime data_publication) {
        this.data_publication = data_publication;
    }

    //    public CategoryDto getCategory() {
//        return category;
//    }
//
//    public void setCategory(CategoryDto category) {
//        this.category = category;
//    }

    @Override
    public String toString() {
        return "FeedDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", data_publication='" + data_publication.toString() + '\'' +
               // ", category=" + category +
                '}';
    }
}
