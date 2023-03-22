package com.codegym.quan_ly_blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(columnDefinition = "date")
    private String time;
    private String status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Blog(int id, String title, String time, String status, Category category) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.status = status;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Blog(int id, String title, String time, String status) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String author) {
        this.time = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
