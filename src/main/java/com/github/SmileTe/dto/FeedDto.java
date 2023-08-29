package com.github.SmileTe.dto;

import com.github.SmileTe.entity.Category;

import java.time.LocalDateTime;
import java.util.Objects;

public class FeedDto {
    private long id;
    private String name;
    private String content;
    private LocalDateTime data_publication;
    private CategoryFeed category;
    //private CategoryDto category;

   // private CategoryDto category;

    public static class CategoryFeed {
        long id;
        String name;

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

        public CategoryFeed(long id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "CategoryFeed{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CategoryFeed that = (CategoryFeed) o;
            return id == that.id && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }


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


    public CategoryFeed getCategory() {
        return category;
    }

    public void setCategory(CategoryFeed category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "FeedDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", data_publication=" + data_publication +
                ", category=" + category +
                '}';
    }
}
