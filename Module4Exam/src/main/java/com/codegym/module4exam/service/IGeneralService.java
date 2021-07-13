package com.codegym.module4exam.service;


import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    T save(T t);
    void remove(Long id);
    Optional<T> findbyId(Long id);
}
