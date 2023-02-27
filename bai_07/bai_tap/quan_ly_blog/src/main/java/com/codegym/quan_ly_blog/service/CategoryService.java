package com.codegym.quan_ly_blog.service;

import com.codegym.quan_ly_blog.model.Category;
import com.codegym.quan_ly_blog.repository.ICategoryRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepoistory categoryRepoistory;

    @Override
    public List<Category> findAll() {
        return categoryRepoistory.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepoistory.save(category);
    }

    @Override
    public Category findById(int id) {
        return categoryRepoistory.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        categoryRepoistory.deleteById(id);
    }

    @Override
    public List<Category> findByName(String nameSearch) {
        return null;
    }

    @Override
    public Page<Category> search(String nameSearch, Pageable pageable) {
        return null;
    }
}
