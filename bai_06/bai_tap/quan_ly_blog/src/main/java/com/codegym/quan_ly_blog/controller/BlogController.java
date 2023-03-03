package com.codegym.quan_ly_blog.controller;

import com.codegym.quan_ly_blog.model.Blog;
import com.codegym.quan_ly_blog.service.IBlogService;
import com.codegym.quan_ly_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("blog/")
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/list")
    public String showList(Model model,
                           @RequestParam(required = false, defaultValue = "") String nameSearch,
                           @RequestParam(required = false, defaultValue = "0") int categorySearch,
                           @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("time").descending());

        Page<Blog> pages;
        if (nameSearch.equals("") && categorySearch == 0) {
            pages = iBlogService.search(nameSearch, pageable);
        } else if (nameSearch.equals("")) {
            pages = iBlogService.searchCategory(categorySearch, pageable);
        } else {
            pages = iBlogService.searchNameAndCategory(nameSearch, categorySearch, pageable);
        }
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("pages", pages);
        model.addAttribute("categorySearch", iCategoryService.findById(categorySearch));
        model.addAttribute("nameSearch", nameSearch);
        return "blog/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("dateCreate", dateCreate());
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setTime(dateCreate());
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Đã thêm thành công");
        return "redirect:/blog/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Blog blog = iBlogService.findById(id);
        iBlogService.delete(blog);
        redirectAttributes.addFlashAttribute("mess", "Đã xoá thành công");
        return "redirect:/blog/list";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công");
        return "redirect:/blog/list";
    }
    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    @GetMapping("/multiDelete")
    public String multiDelete(@RequestParam String idDeleteMore) {
        idDeleteMore = removeCharAt(idDeleteMore, 0);

        String[] idDelete = idDeleteMore.split("\\.");
        int[] arrId = new int[idDelete.length];
        for (int i = 0; i < idDelete.length; i++) {
            arrId[i] = Integer.parseInt(idDelete[i]);
        }

        for (int i : arrId) {
            Blog blog = new Blog();
            blog = iBlogService.findById(i);
            iBlogService.delete(blog);
        }
        return "redirect:/blog/list";
    }

    public String dateCreate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateCreate = format.format(date);
        return dateCreate;
    }
//    @GetMapping("/search")
//    public String searchProduct(@RequestParam String nameSearch, Model model) {
//        model.addAttribute("blogList", iBlogService.findByName(nameSearch));
//        return "blog/list";
//    }
}
