package com.codegym.ung_dung_muon_sach.service;

import com.codegym.ung_dung_muon_sach.model.BookRental;
import com.codegym.ung_dung_muon_sach.repository.IBookRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRentalService implements IBookRentalService{
    @Autowired
    IBookRentalRepository iBookRentalRepository;


    @Override
    public List<BookRental> findAll() {
        return iBookRentalRepository.findAll();
    }

    @Override
    public BookRental findById(int id) {
        return iBookRentalRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BookRental bookRental) {
        iBookRentalRepository.save(bookRental);
    }

    @Override
    public void deleteById(int id) {
        iBookRentalRepository.deleteById(id);
    }
}
