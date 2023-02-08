package com.codegym.controller;

import com.codegym.model.MailboxSetting;
import com.codegym.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("mailbox/")
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
        return "create";
    }

    @PostMapping("/settings")
    public String saveSettings(@ModelAttribute MailboxSetting mailboxSettings, RedirectAttributes redirectAttributes){
        mailboxService.save(mailboxSettings);
        redirectAttributes.addFlashAttribute("mess", "Đã thêm setting!");
        return "redirect:/mailbox/list";
    }

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("settingList", mailboxService.findAll());
        return "list";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model){
        MailboxSetting mailboxSetting = mailboxService.findById(id);
        model.addAttribute("mailbox", mailboxSetting);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute MailboxSetting mailboxSetting, RedirectAttributes redirectAttributes){
        mailboxService.editSettings(mailboxSetting.getId(), mailboxSetting);
        redirectAttributes.addFlashAttribute("mess", "Đã sửa!");
        return "redirect:/mailbox/list";
    }
}
