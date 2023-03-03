package com.codegym.furama_resort.service.customer;

import com.codegym.furama_resort.model.customer.Customer;
import com.codegym.furama_resort.model.customer.CustomerType;
import com.codegym.furama_resort.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
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

    @Override
    public void remove(Customer customer) {
        iCustomerRepository.delete(customer);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findByNameContaining(String nameSearch, Pageable pageable) {
        return iCustomerRepository.findByNameContaining(nameSearch, pageable);
    }

    @Override
    public Page<Customer> findByCustomer_type_id(int id, Pageable pageable) {
        return iCustomerRepository.findByCustomerType_Id(id, pageable);
    }

    @Override
    public Page<Customer> findByNameContainingAndCustomer_type_id(String nameSearch, int id, Pageable pageable) {
        return iCustomerRepository.findByNameContainingAndCustomerType_Id(nameSearch, id, pageable);
    }


}
