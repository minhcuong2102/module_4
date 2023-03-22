package com.codegym.quan_ly_blog.service;

import com.codegym.quan_ly_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void remove(int id);

    List<Blog> findByName(String nameSearch);

    List<Blog> findByCategory_Id(int id);

    Page<Blog> search(String nameSearch, Pageable pageable);

    Page<Blog> searchCategory(Integer id, Pageable pageable);

    Page<Blog> searchNameAndCategory(String searchName, Integer id, Pageable pageable);
}
