package com.codegym.furama_resort.repository.customer;

import com.codegym.furama_resort.model.customer.Customer;
import com.codegym.furama_resort.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findByNameContaining(String name, Pageable pageable);

    Page<Customer> findByCustomerType_Id(int id, Pageable pageable);

    Page<Customer> findByNameContainingAndCustomerType_Id(String name, int id, Pageable pageable);
}
