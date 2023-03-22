package com.codegym.quan_ly_blog.repository;

import com.codegym.quan_ly_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByCategory_Id(int id);

    Page<Blog> findByTitleContaining(@Param("title") String title, Pageable pageable);

    Page<Blog> findByCategory_Id(Integer id, Pageable pageable);

    Page<Blog> findByTitleContainingAndCategory_Id(String nameSearch, Integer id, Pageable pageable);
}
