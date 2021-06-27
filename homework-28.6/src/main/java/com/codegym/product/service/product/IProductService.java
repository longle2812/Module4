package com.codegym.product.service.product;

import com.codegym.product.model.Product;
import com.codegym.product.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService extends IGeneralService<Product> {
    Page<Product> findProductByNameContaining(Pageable pageable, String search);
}
