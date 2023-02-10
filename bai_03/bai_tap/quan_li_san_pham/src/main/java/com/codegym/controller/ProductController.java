package com.codegym.controller;

import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")
    public String showList(){
        return "index";
    }
}
