package com.codegym.furama_resort.service.employee.impl;

import com.codegym.furama_resort.model.employee.EducationDegree;
import com.codegym.furama_resort.repository.employee.IEducationDegreeRepository;
import com.codegym.furama_resort.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}
