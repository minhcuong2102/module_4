package com.codegym.controller;

import com.codegym.model.MailboxSetting;
import com.codegym.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MailboxController {
    @Autowired
    IMailboxService mailboxService;

    @ModelAttribute("languages")
    public String[] array1(){
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @ModelAttribute("pageSize")
    public int[] array2(){
        return new int[]{5, 10, 15, 25, 50, 100};
    }

    @GetMapping("/settings")
    public String showSettings(Model model){
        model.addAttribute("mailboxSettings", new MailboxSetting());
        return "index";
    }

    @PostMapping("/save")
    public String saveSettings(@ModelAttribute MailboxSetting mailboxSettings, Model model, RedirectAttributes redirectAttributes){
        mailboxService.save(mailboxSettings);
        redirectAttributes.addFlashAttribute("mess", "Đã thêm setting!");
        return "redirect:/list";
    }
}
