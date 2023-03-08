package com.codegym.furama_resort.controller;

import com.codegym.furama_resort.model.customer.Customer;
import com.codegym.furama_resort.model.employee.Employee;
import com.codegym.furama_resort.service.employee.IDivisionService;
import com.codegym.furama_resort.service.employee.IEducationDegreeService;
import com.codegym.furama_resort.service.employee.IEmployeeService;
import com.codegym.furama_resort.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    IDivisionService iDivisionService;

    @Autowired
    IEducationDegreeService iEducationDegreeService;

    @Autowired
    IPositionService iPositionService;

    @GetMapping("")
    public String showList(Model model){


        model.addAttribute("employeeList");
        return "/employee/list";
    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    @GetMapping("/multiDelete")
    public String multiDelete(@RequestParam String idDeleteMore) {
        idDeleteMore = removeCharAt(idDeleteMore, 0);

        String[] idDelete = idDeleteMore.split("\\.");
        int[] arrId = new int[idDelete.length];
        for (int i = 0; i < idDelete.length; i++) {
            arrId[i] = Integer.parseInt(idDelete[i]);
        }

        for (int i : arrId) {
            Employee employee = new Employee();
            employee = iEmployeeService.findById(i);
            iEmployeeService.remove(employee);
        }
        return "redirect:/employee";
    }

    public String dateCreate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Customer());
        model.addAttribute("dateCreate", dateCreate());
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
        return "/employee/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("mess", "Đã thêm thành công");
        return "redirect:/employee";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Employee employee = iEmployeeService.findById(id);
        iEmployeeService.remove(employee);
        redirectAttributes.addFlashAttribute("mess", "Đã xoá thành công");
        return "redirect:/employee";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model) {
        model.addAttribute("employee", new Customer());
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
        return "employee/edit";
    }

    @PostMapping("/update")
    public String update(Employee employee, RedirectAttributes redirectAttributes) {
        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công");
        return "redirect:/employee";
    }
}
