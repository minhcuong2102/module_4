package com.codegym.quan_ly_blog.service;

import com.codegym.quan_ly_blog.model.Blog;
import com.codegym.quan_ly_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> search(String title, Pageable pageable) {
        return iBlogRepository.findByTitleContaining(title, pageable);
    }

    @Override
    public Page<Blog> searchCategory(Integer id, Pageable pageable) {
        return iBlogRepository.findByCategory_Id(id, pageable);
    }

    @Override
    public Page<Blog> searchNameAndCategory(String nameSearch, Integer id, Pageable pageable) {
        return iBlogRepository.findByTitleContainingAndCategory_Id(nameSearch, id, pageable);
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByName(String nameSearch) {
        List<Blog> listResult = new ArrayList<>();
        for (Blog s : iBlogRepository.findAll()) {
            if (s.getTitle().contains(nameSearch.toLowerCase())) {
                listResult.add(s);
            }
        }
        return listResult;
    }
}
