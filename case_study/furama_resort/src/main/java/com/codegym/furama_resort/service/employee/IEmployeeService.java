package com.codegym.furama_resort.service.employee;

import com.codegym.furama_resort.model.customer.Customer;
import com.codegym.furama_resort.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    Employee findById(int id);

    void remove(int id);

    void remove(Employee employee);

    Page<Employee> searchEmployee(String nameSearch, String emailSearch, String divisionSearch, Pageable pageable);
}
