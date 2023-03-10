package com.codegym.cart.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);
            productMap.replace(productDto, currentValue + 1);
        } else {
            productMap.put(productDto, 1);
        }
    }

    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }

    public void increaseProduct(ProductDto productDto) {
        Integer currentValue = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().getId() == productDto.getId()) {
                currentValue = entry.getValue();
            }
        }

        productDto.setPrice(productDto.getPrice() + productDto.getPrice());
        productMap.replace(productDto, currentValue + 1);
    }

    public void decrementProduct(ProductDto productDto) {
        Integer currentValue = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().getId() == productDto.getId()) {
                currentValue = entry.getValue();
            }
        }
        if (currentValue == 1) {
            removeProduct(productDto);
        } else {
            productMap.replace(productDto, currentValue - 1);
        }
    }

    public void removeProduct(ProductDto productDto) {
        productMap.remove(productDto);
    }
}
