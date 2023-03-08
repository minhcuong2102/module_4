package com.codegym.furama_resort.service.employee.impl;

import com.codegym.furama_resort.model.employee.Division;
import com.codegym.furama_resort.repository.employee.IDivisionRepository;
import com.codegym.furama_resort.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}
