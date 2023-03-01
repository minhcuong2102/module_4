package com.codegym.furama_resort.controller;

import com.codegym.furama_resort.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @GetMapping("")
    public String showList(Model model){
        return "/customer/list";
    }
}
