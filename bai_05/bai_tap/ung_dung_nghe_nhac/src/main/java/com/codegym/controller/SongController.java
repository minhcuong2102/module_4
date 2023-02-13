package com.codegym.controller;

import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("song/")
public class SongController {
    @Autowired
    ISongService songService;

    @GetMapping("/list")
    public String showList(ModelMap modelMap) {
        modelMap.addAttribute("productList", songService.findAll());
        return "list";
    }
}
