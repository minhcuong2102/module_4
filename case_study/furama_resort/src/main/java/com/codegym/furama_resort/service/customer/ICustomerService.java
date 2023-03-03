package com.codegym.furama_resort.service.customer;

import com.codegym.furama_resort.model.customer.Customer;
import com.codegym.furama_resort.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void remove(int id);

    void remove(Customer customer);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByNameContaining(String nameSearch, Pageable pageable);

    Page<Customer> findByCustomer_type_id(int id, Pageable pageable);

    Page<Customer> findByNameContainingAndCustomer_type_id(String nameSearch, int id, Pageable pageable);
}
