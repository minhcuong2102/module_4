package com.codegym.ung_dung_muon_sach.dto;

import com.codegym.ung_dung_muon_sach.model.BookRental;

import java.util.Set;

public class BookDto {
    private int id;
    private String name;
    private int count;
    private Set<BookRental> bookRentals;

    public BookDto() {
    }

    public BookDto(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
