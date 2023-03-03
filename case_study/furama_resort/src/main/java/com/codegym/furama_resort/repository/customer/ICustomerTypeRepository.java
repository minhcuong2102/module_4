package com.codegym.furama_resort.repository.customer;

import com.codegym.furama_resort.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
