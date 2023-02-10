package com.codegym.service;

import com.codegym.model.ToKhaiYTe;
import com.codegym.repository.ITKYTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TKYTService implements ITKYTService{
    @Autowired
    ITKYTRepository repository;
    @Override
    public List<ToKhaiYTe> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(ToKhaiYTe toKhaiYTe) {
        repository.save(toKhaiYTe);
    }
}
