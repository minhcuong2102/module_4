package com.codegym.cart.controller;

import com.codegym.cart.dto.CartDto;
import com.codegym.cart.dto.ProductDto;
import com.codegym.cart.model.Product;
import com.codegym.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    IProductService iProductService;

    @GetMapping("")
    public ModelAndView showCart(@SessionAttribute(name = "cart", required = false) CartDto cartDto) {
        return new ModelAndView("cart", "cart", cartDto);
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, @SessionAttribute(name = "cart", required = false) CartDto cart) {
        Product product = iProductService.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cart.removeProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/decrease/{id}")
    public String decrease(@PathVariable int id, @SessionAttribute(name = "cart", required = false) CartDto cart) {
        Product product = iProductService.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cart.decrementProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/increase")
    public String increase(@RequestParam int id, @SessionAttribute(name = "cart", required = false) CartDto cart) {
        Product product = iProductService.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cart.increaseProduct(productDto);
        }
        return "redirect:/cart";
    }
}
