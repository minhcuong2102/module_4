package com.codegym.furama_resort.service.customer;

import com.codegym.furama_resort.model.customer.CustomerType;
import com.codegym.furama_resort.repository.customer.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(int typeSearch) {
        return iCustomerTypeRepository.findById(typeSearch).orElse(null);
    }
}
