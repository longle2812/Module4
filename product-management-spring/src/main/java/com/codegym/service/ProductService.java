package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Banana", 100 , "made in Vietnam","Vietnam"));
        products.put(2, new Product(2, "Apple", 200 , "made in Thai","Vietnam"));
        products.put(3, new Product(3, "Grape", 150 , "made in Singapore","Vietnam"));
        products.put(4, new Product(4, "Orange", 160 , "made in China","Vietnam"));
        products.put(5, new Product(5, "Dragon Fruit", 180 , "made in England","Vietnam"));
        products.put(6, new Product(6, "Watermelon", 50 , "made in Australia","Vietnam"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values()) ;
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }
}
