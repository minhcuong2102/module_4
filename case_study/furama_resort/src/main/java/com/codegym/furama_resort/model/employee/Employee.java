package com.codegym.furama_resort.model.employee;

import com.codegym.furama_resort.model.customer.CustomerType;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

}
