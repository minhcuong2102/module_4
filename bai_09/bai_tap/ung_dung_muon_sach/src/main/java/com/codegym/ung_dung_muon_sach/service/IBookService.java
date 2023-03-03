package com.codegym.ung_dung_muon_sach.service;

import com.codegym.ung_dung_muon_sach.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(int id);
    void save(Book book);
    void deleteById(int id);
}
