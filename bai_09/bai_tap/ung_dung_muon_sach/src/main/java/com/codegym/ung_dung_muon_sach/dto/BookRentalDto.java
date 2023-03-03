package com.codegym.ung_dung_muon_sach.dto;

import com.codegym.ung_dung_muon_sach.model.Book;

import javax.validation.constraints.Size;

public class BookRentalDto {
    private int id;
    @Size(min = 5, max = 5, message = "Mã sách phải đúng 5 kí tự")
    private String rentId;
    private Book bookId;
    private int statusId;

    public BookRentalDto() {
    }

    public BookRentalDto(int id, String rentId, Book bookId, int statusId) {
        this.id = id;
        this.rentId = rentId;
        this.bookId = bookId;
        this.statusId = statusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
}
