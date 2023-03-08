package com.codegym.furama_resort.service.employee;

import com.codegym.furama_resort.model.customer.Customer;
import com.codegym.furama_resort.model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(int id);

    void remove(int id);

    void remove(Employee employee);
}
