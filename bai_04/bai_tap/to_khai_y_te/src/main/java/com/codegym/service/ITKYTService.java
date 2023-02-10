package com.codegym.service;

import com.codegym.model.ToKhaiYTe;

import java.util.List;

public interface ITKYTService {
    List<ToKhaiYTe> findAll();
    void save(ToKhaiYTe toKhaiYTe);
}
