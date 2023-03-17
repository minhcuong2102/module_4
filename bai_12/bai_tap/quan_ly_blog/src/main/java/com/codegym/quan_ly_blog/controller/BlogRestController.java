package com.codegym.quan_ly_blog.controller;

import com.codegym.quan_ly_blog.model.Blog;
import com.codegym.quan_ly_blog.model.Category;
import com.codegym.quan_ly_blog.service.IBlogService;
import com.codegym.quan_ly_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    ICategoryService categoryService;

    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> showList() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> showBlog(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{categoryId}/category")
    public ResponseEntity<List<Blog>> showBlogByCategoryId(@PathVariable int categoryId) {
        List<Blog> blogList = blogService.findByCategory_Id(categoryId);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PatchMapping("/edit")
    public ResponseEntity<?> editBlog(@RequestBody Blog blog) {
        Blog blog1 = blogService.findById(blog.getId());
        if (blog1 == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Blog>> searchBlog(@PathVariable String name) {
        List<Blog> blogList = blogService.search(name);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    private int cnt = 0;

    @GetMapping("/quantity")
    public ResponseEntity<List<Blog>> showLimit() {
        cnt += 2;
        List<Blog> blogList = blogService.findAll(cnt);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
