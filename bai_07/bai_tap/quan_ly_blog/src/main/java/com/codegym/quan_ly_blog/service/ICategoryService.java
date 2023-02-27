package com.codegym.quan_ly_blog.service;

import com.codegym.quan_ly_blog.model.Blog;
import com.codegym.quan_ly_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(int id);

    void remove(int id);

    List<Category> findByName(String nameSearch);

    Page<Category> search(String nameSearch, Pageable pageable);
}
