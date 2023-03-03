package com.codegym.ung_dung_muon_sach.service;

import com.codegym.ung_dung_muon_sach.model.Book;
import com.codegym.ung_dung_muon_sach.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    IBookRepository iBookRepository;


    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void deleteById(int id) {
        iBookRepository.deleteById(id);
    }
}
