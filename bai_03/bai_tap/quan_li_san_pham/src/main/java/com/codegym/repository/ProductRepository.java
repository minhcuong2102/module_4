package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Quạt", 200000, "Mát", "Toshiba"));
        productList.add(new Product(2, "Laptop", 20000000, "Chạy ngon", "acer"));
        productList.add(new Product(3, "Iphone14", 25000000, "style", "Apple"));
        productList.add(new Product(4, "Máy giặt", 1200000, "Lợi điện", "Panasonic"));
        productList.add(new Product(5, "TV", 7000000, "fashionable style", "Samsung"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        productList.remove(id - 1);
    }

    @Override
    public void update(int id, Product product) {
        productList.set(id, product);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> listResult = new ArrayList<>();
        for (Product s: productList) {
            if (s.getName().contains(name.toLowerCase())){
                listResult.add(s);
            }
        }
        return listResult;
    }
}
