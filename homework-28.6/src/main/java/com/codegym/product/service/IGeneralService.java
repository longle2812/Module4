package com.codegym.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneralService<T>{
    Page<T> findAll(Pageable pageable);
    Optional<T> findById(Long id);
    void remove(Long id);
    void save(T t);
}
