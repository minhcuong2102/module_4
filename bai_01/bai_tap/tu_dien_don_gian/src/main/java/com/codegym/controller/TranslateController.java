package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslateController {
    public static final Map<String, String> dictionary;
    static {
        dictionary = new HashMap<>();
        dictionary.put("hello", "xin chào");
        dictionary.put("goodbye", "tạm biệt");
        dictionary.put("apple", "quả táo");
        dictionary.put("computer", "máy tính");
    }

    @GetMapping(value = "/dictionary")
    public String show() {
        return "dictionary";
    }

    @PostMapping(value = "/translate")
    public String translate(@RequestParam String eng, Model model) {
        String result = dictionary.get(eng.toLowerCase());
        model.addAttribute("result", result);
        model.addAttribute("eng", eng);
        return "dictionary";
    }
}
