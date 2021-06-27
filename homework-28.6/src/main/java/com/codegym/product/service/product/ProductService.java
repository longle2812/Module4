package com.codegym.product.service.product;

import com.codegym.product.model.Product;
import com.codegym.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findProductByNameContaining(Pageable pageable, String search) {
        return productRepository.findProductByNameContaining(pageable, search);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
