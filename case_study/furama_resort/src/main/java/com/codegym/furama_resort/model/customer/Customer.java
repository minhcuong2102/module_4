package com.codegym.furama_resort.model.customer;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customer_type_id;
    private String name;
    private String date_of_birth;
    private boolean gender;
    private String id_card;
    private String phone_number;
    private String email;
    private String address;
}
