package com.example.quan_ly_dien_thoai.service;

import com.example.quan_ly_dien_thoai.model.Smartphone;

import java.util.List;
import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();

    List<Smartphone> findAllSmartphone();

    Optional<Smartphone> findById(int id);

    Smartphone save(Smartphone smartPhone);

    void remove(int id);
}
