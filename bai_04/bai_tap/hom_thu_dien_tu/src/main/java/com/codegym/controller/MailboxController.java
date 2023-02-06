package com.codegym.controller;

import com.codegym.model.MailboxSettings;
import com.codegym.repository.IMailboxRepository;
import com.codegym.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
@RequestMapping("mailbox/")
public class MailboxController {
    @Autowired
    IMailboxService mailboxService;

    @ModelAttribute("languages")
    public String[] arrayLanguages() {
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @ModelAttribute("pageSize")
    public int[] arrayPageSize() {
        return new int[]{5, 10, 15, 25, 50, 100};
    }

    @GetMapping("/settings")
    public String showFormSettings(Model model) {
        model.addAttribute("mailboxSettings", new MailboxSettings());
        return "settings";
    }

    @PostMapping("/settings")
    public String save(@ModelAttribute MailboxSettings mailboxSettings, Model model, RedirectAttributes redirectAttributes){
        mailboxService.save(mailboxSettings);
        redirectAttributes.addFlashAttribute("mess", "Cấu hình thành công");
        return "redirect:/list";
    }
}
