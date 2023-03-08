package com.codegym.furama_resort.service.employee.impl;

import com.codegym.furama_resort.model.employee.Employee;
import com.codegym.furama_resort.repository.employee.IEmployeeRepository;
import com.codegym.furama_resort.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;


    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public void remove(Employee employee) {
        iEmployeeRepository.delete(employee);
    }


}
