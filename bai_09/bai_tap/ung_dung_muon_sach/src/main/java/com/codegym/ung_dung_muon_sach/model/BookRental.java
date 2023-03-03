package com.codegym.ung_dung_muon_sach.model;

import javax.persistence.*;

@Entity
public class BookRental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String rentId;

    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    private Book bookId;

    private int statusId;

    public BookRental() {
    }

    public BookRental(int id, String rentId, Book bookId, int statusId) {
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
