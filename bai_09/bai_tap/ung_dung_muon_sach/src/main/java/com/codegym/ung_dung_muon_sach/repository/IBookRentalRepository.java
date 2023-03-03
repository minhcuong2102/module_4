package com.codegym.ung_dung_muon_sach.repository;

import com.codegym.ung_dung_muon_sach.model.BookRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRentalRepository extends JpaRepository<BookRental, Integer> {
}
