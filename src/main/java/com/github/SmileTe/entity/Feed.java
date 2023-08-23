package com.github.SmileTe.entity;

import com.github.SmileTe.dto.CategoryDto;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.usertype.UserType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

@Entity
@Table(name = "feeds")
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String content;
    @Column(name = "data_publication")
    //@CreationTimestamp
    private LocalDateTime dataPublication;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id")
    private Category category;

    public Long getId() {
        return id;
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

    public LocalDateTime  getDataPublication() {
        return dataPublication;
    }

//    public String  getDataPublication() {
//        SimpleDateFormat dateFormat
//                = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        return dateFormat.format(this.dataPublication);
//    }

    public void setDataPublication(LocalDateTime  dataPublication) {
        this.dataPublication = dataPublication;
    }

//    public void setDataPublication(String timezone) throws ParseException {
////        SimpleDateFormat dateFormat
////                = new SimpleDateFormat("yyyy-MM-dd HH:mm");
////        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
////        this.dataPublication =  dateFormat.;
//    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Feed() {
    }

    public Feed(String name, String content, LocalDateTime  dataPublication, Category category) {
        this.name = name;
        this.content = content;
        this.dataPublication = dataPublication;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feed feed = (Feed) o;
        return Objects.equals(id, feed.id) && Objects.equals(name, feed.name) && Objects.equals(content, feed.content) && Objects.equals(dataPublication, feed.dataPublication) && Objects.equals(category, feed.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, content, dataPublication, category);
    }

    @Override
    public String toString() {
        return "Feed{" +
                //"id=" + id +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", dataPublication='" + dataPublication + '\'' +
                ", category=" + category +
                '}';
    }
}
