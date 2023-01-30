package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping(value = "converter")
    public String show(){
        return "converter";
    }
    @PostMapping(value = "chuyen-doi")
    public String convert(@RequestParam String usd, String rate, Model model){
        double result = Double.parseDouble(usd) * Double.parseDouble(rate);
        model.addAttribute("result", result);
        return "result";
    }
}
