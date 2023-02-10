package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Quạt", 200000, "Mát", "Toshiba"));
        products.put(2, new Product(2, "Laptop", 20000000, "Chạy ngon", "acer"));
        products.put(3, new Product(3, "Iphone14", 25000000, "style", "Apple"));
        products.put(4, new Product(4, "Máy giặt", 1200000, "Lợi điện", "Panasonic"));
        products.put(5, new Product(5, "TV", 7000000, "fashionable style", "Samsung"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }
}
