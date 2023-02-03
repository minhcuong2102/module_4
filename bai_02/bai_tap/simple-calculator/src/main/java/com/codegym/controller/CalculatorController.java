package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping("")
    public String show() {
        return "index";
    }

    @PostMapping("/result")
    public String calculate(@RequestParam double num1, @RequestParam double num2, @RequestParam String calculation, ModelMap model) {
        double result;
        switch (calculation) {
            case "Addition(+)":
                result = num1 + num2;
                break;

            case "Subtraction(-)":
                result = num1 - num2;
                break;

            case "Multiplication(*)":
                result = num1 * num2;
                break;

            case "Division(/)":
                result = num1 / num2;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + calculation);
        }
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", result);
        return "index";
    }
}
