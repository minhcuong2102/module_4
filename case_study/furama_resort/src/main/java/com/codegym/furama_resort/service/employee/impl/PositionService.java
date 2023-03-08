package com.codegym.furama_resort.service.employee.impl;

import com.codegym.furama_resort.model.employee.Position;
import com.codegym.furama_resort.repository.employee.IPositionRepository;
import com.codegym.furama_resort.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    IPositionRepository iPositionRepository;

    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}
