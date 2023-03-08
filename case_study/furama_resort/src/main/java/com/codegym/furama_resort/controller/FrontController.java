package com.codegym.furama_resort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {
    @GetMapping("/home")
    public String home(){
        return "layout";
    }

    @GetMapping("")
    public String redirect(){
        return "redirect:/home";
    }
}
