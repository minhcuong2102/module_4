package com.codegym.furama_resort.service.customer;

import com.codegym.furama_resort.model.customer.Customer;
import com.codegym.furama_resort.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    ICustomerRepository iCustomerRepository;


    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        iCustomerRepository.deleteById(id);
    }


}
