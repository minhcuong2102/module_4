package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("product/")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/list")
    public String showList(ModelMap modelMap){
        modelMap.addAttribute("productList", productService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("mess", "Đã thêm sản phẩm");
        return "redirect:/product/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes){
        productService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Đã xoá sản phẩm");
        return "redirect:/product/list";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Product product){
        productService.update(product.getId(),product);
        return "redirect:/product/list";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam String search, Model model){
        model.addAttribute("productList",productService.findByName(search));
        return "list";
    }
}
