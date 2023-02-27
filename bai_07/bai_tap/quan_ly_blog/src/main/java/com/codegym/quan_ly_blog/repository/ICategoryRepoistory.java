package com.codegym.quan_ly_blog.repository;

import com.codegym.quan_ly_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepoistory extends JpaRepository<Category, Integer> {
}
