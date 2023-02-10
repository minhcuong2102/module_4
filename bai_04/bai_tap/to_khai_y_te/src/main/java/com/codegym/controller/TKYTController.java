package com.codegym.controller;

import com.codegym.model.ToKhaiYTe;
import com.codegym.service.ITKYTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.ArrayList;

@Controller
@RequestMapping("tkyt/")
public class TKYTController {
    @Autowired
    ITKYTService itkytService;

    @ModelAttribute("year")
    public String[] yearList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1970; i <= 2023; i++) {
            list.add(String.valueOf(i));
        }
        return list.toArray(new String[0]);
    }

    @ModelAttribute("nationality")
    public String[] nationalityList() {
        return new String[]{"Việt Nam", "Hoa Kỳ", "Nhật Bản", "Hàn Quốc", "Trung Quốc", "Pháp", "Nga"};
    }

    @ModelAttribute("transportation")
    public String[] transportationList() {
        return new String[]{"Tàu bay", "Tàu thuyền", "Ô tô", "Khác (Ghi rõ)"};
    }

    @ModelAttribute("day")
    public String[] dayList(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 31; i++) {
            list.add(String.valueOf(i));
        }
        return list.toArray(new String[0]);
    }

    @ModelAttribute("month")
    public String[] monthList(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            list.add(String.valueOf(i));
        }
        return list.toArray(new String[0]);
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("toKhaiYTe", new ToKhaiYTe());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute ToKhaiYTe toKhaiYTe, Model model, RedirectAttributes redirectAttributes){
        itkytService.save(toKhaiYTe);
        redirectAttributes.addFlashAttribute("mess", "Đã thêm thành công!");
        return "redirect:/tkyt/list";
    }

    @GetMapping("/list")
    public String home(Model model){
        model.addAttribute("toKhaiYTe",itkytService.findAll());
        return "list";
    }
}
