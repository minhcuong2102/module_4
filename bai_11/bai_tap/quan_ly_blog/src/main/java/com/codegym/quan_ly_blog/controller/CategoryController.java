package com.codegym.quan_ly_blog.controller;

import com.codegym.quan_ly_blog.model.Blog;
import com.codegym.quan_ly_blog.model.Category;
import com.codegym.quan_ly_blog.service.IBlogService;
import com.codegym.quan_ly_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("category/")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @Autowired
    IBlogService blogService;

    @GetMapping("/list")
    public String showCategory(Model model){
        List<Blog> blogList = blogService.findAll();
        List<Category> categoryList = categoryService.findAll();
        for (Category category : categoryList){
            for (Blog blog : blogList){
                if (blog.getCategory().getId() == category.getId()){
                    category.getBlogSet().add(blog);
                }
            }
        }
        model.addAttribute("categoryList", categoryList);
        return "category/category";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("categoryList", categoryService.findAll());
        return "category/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess", "Đã thêm thành công");
        return "redirect:/category/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        categoryService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Đã xoá thành công");
        return "redirect:/category/list";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        model.addAttribute("categoryList", categoryService.findAll());
        return "category/edit";
    }

    @PostMapping("/update")
    public String update(Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công");
        return "redirect:/category/list";
    }
}
