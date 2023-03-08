package com.codegym.furama_resort.controller;

import com.codegym.furama_resort.model.customer.Customer;
import com.codegym.furama_resort.model.customer.CustomerType;
import com.codegym.furama_resort.repository.customer.ICustomerTypeRepository;
import com.codegym.furama_resort.service.customer.ICustomerService;
import com.codegym.furama_resort.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(required = false, defaultValue = "") String nameSearch,
                           @RequestParam(required = false, defaultValue = "0") int typeSearch,
                           @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("name").ascending());
        Page<Customer> customerList = null;

        if (typeSearch == 0) {
            customerList = iCustomerService.findByNameContaining(nameSearch, pageable);
        } else if (nameSearch.equals("")) {
            customerList = iCustomerService.findByCustomer_type_id(typeSearch, pageable);
        } else {
            customerList = iCustomerService.findByNameContainingAndCustomer_type_id(nameSearch, typeSearch, pageable);
        }

        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("typeSearch", typeSearch);
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("customerList", customerList);
        return "/customer/list";
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
            Customer customer = new Customer();
            customer = iCustomerService.findById(i);
            iCustomerService.remove(customer);
        }
        return "redirect:/customer";
    }

    public String dateCreate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("dateCreate", dateCreate());
        model.addAttribute("customerType", iCustomerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Đã thêm thành công");
        return "redirect:/customer";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Customer customer = iCustomerService.findById(id);
        iCustomerService.remove(customer);
        redirectAttributes.addFlashAttribute("mess", "Đã xoá thành công");
        return "redirect:/customer";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        model.addAttribute("customerType", iCustomerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(Customer blog, RedirectAttributes redirectAttributes) {
        iCustomerService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công");
        return "redirect:/customer";
    }
}
