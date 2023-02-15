package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("song/")
@PropertySource("classpath:upload_file.properties")
public class SongController {
    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    ISongService songService;

    @GetMapping("/list")
    public String showList(ModelMap modelMap) {
        modelMap.addAttribute("songList", songService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("song", new Song());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveProduct(@ModelAttribute Song song, RedirectAttributes redirectAttributes) {
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Đã thêm thành công!");
        return "redirect:/song/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        songService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Đã xoá thành công!");
        return "redirect:/song/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("id1", songService.findById(id).getId());
        model.addAttribute("song", songService.findById(id));
        return "edit";
    }

    @PostMapping("/edit/{id1}")
    public String editProduct(@ModelAttribute Song song, @PathVariable int id1, Model model, RedirectAttributes redirectAttributes) {
        songService.update(id1, song);
        model.addAttribute("product", songService.findAll());
        redirectAttributes.addFlashAttribute("mess", "Đã sửa thành công!");
        return "redirect:/song/list";
    }

//    @GetMapping("/search")
//    public String searchProduct(@RequestParam String search, Model model) {
//        model.addAttribute("productList", songService.findByName(search));
//        return "list";
//    }
}
