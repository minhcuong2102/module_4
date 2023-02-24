package com.codegym.validate_form_dang_ki.controller;

import com.codegym.validate_form_dang_ki.model.User;
import com.codegym.validate_form_dang_ki.model.UserDto;
import com.codegym.validate_form_dang_ki.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user/")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam(defaultValue = "0") int page){
        String name = "";
        Pageable pageable = PageRequest.of(page, 2, Sort.by("firstName").ascending());
        Page<User> page1 = userService.findUserByFirstName(name, pageable);
        model.addAttribute("userList", page1);
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam int id) {
        userService.delete(id);
        return "redirect:/user/list";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("userDto", userService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editUser(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        return "redirect:/user/list";
    }
}
