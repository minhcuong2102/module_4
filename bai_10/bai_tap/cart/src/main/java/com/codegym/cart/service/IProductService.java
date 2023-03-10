package com.codegym.cart.service;

import com.codegym.cart.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    void update(Product product);

    Product findById(int id);

    void deleteById(int id);
}
