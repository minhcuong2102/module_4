package com.codegym.ung_dung_muon_sach.service;

import com.codegym.ung_dung_muon_sach.model.BookRental;

import java.util.List;

public interface IBookRentalService {
    List<BookRental> findAll();
    BookRental findById(int id);
    void save(BookRental bookRental);
    void deleteById(int id);
}
