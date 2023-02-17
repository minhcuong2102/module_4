package com.codegym.quan_ly_blog.service;

import com.codegym.quan_ly_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void remove(int id);

    List<Blog> findByName(String nameSearch);
}
