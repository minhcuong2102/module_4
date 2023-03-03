package com.codegym.furama_resort.service.customer;

import com.codegym.furama_resort.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();

    CustomerType findById(int typeSearch);
}
