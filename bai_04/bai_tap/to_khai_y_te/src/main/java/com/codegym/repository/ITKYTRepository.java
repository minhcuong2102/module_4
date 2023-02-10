package com.codegym.repository;

import com.codegym.model.ToKhaiYTe;

import java.util.List;

public interface ITKYTRepository {
    List<ToKhaiYTe> findAll();
    void save(ToKhaiYTe toKhaiYTe);
}
