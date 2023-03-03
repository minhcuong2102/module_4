package com.codegym.ung_dung_muon_sach.controller;

import com.codegym.ung_dung_muon_sach.dto.BookDto;
import com.codegym.ung_dung_muon_sach.dto.BookRentalDto;
import com.codegym.ung_dung_muon_sach.model.Book;
import com.codegym.ung_dung_muon_sach.model.BookRental;
import com.codegym.ung_dung_muon_sach.service.IBookRentalService;
import com.codegym.ung_dung_muon_sach.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    IBookService iBookService;

    @Autowired
    IBookRentalService iBookRentalService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("bookList", iBookService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("bookDto", new BookDto());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute BookDto bookDto, Model model) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        iBookService.save(book);
        model.addAttribute("bookList", iBookService.findAll());
        return "redirect:/book";
    }

    @GetMapping("/rent")
    public String showFormRent(Model model) {
        model.addAttribute("bookRentalDto", new BookRentalDto());
        model.addAttribute("bookList", iBookService.findAll());
        return "rent";
    }

    @GetMapping("/return")
    public String showFormReturn(Model model) {
        model.addAttribute("bookRentalDto", new BookRentalDto());
        model.addAttribute("bookList", iBookService.findAll());
        return "return";
    }

    @PostMapping("/library/rent")
    public String rent(@Validated @ModelAttribute BookRentalDto bookRentalDto, BindingResult bindingResult, Model model) {
        String messageError = "Không có sách để mượn!";
        if (bindingResult.hasFieldErrors()) {

            return "rent";
        }
        BookRental bookRental = new BookRental();
        BeanUtils.copyProperties(bookRentalDto, bookRental);
        Book book = iBookService.findById(bookRentalDto.getBookId().getId());
        if (book.getCount() == 0) {
            model.addAttribute("mess", messageError);
            model.addAttribute("bookRentalDto", new BookRentalDto());
            model.addAttribute("bookList", iBookService.findAll());
            return "rent";
        }
        book.setCount(book.getCount() - 1);
        iBookService.save(book);
        iBookRentalService.save(bookRental);
        model.addAttribute("bookList", iBookService.findAll());
        return "redirect:/book";
    }

    @PostMapping("/library/return")
    public String returnBook(@Validated @ModelAttribute BookRentalDto bookRentalDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {

            return "return";
        }
        List<BookRental> bookRentalList = iBookRentalService.findAll();
        boolean findOut = false;
        BookRental bookRental = new BookRental();
        String messageRentIdNotTrue = "Mã thuê không đúng, thử lại!";
        String messageReturned = "Sách đã trả, thử lại!";
        for (BookRental r : bookRentalList) {
            if (bookRentalDto.getRentId().equals(r.getRentId())) {
                bookRental = iBookRentalService.findById(r.getId());
                if (bookRental.getStatusId() == 0) {
                    model.addAttribute("mess", messageReturned);
                    return "return";
                }
                bookRental.setStatusId(0);
                iBookRentalService.save(bookRental);
                findOut = true;
            }
        }
        if (!findOut) {
            model.addAttribute("mess", messageRentIdNotTrue);
            return "return";
        }
        Book bookLibrary = iBookService.findById(bookRental.getBookId().getId());
        bookLibrary.setCount(bookLibrary.getCount() + 1);
        iBookService.save(bookLibrary);
        model.addAttribute("bookList", iBookService.findAll());
        return "redirect:/book";
    }
}
