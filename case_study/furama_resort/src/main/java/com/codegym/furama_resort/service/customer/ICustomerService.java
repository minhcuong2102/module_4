package com.codegym.furama_resort.service.customer;

import com.codegym.furama_resort.model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void remove(int id);


}
