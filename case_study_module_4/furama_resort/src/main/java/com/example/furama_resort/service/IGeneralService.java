package com.example.furama_resort.service;

import java.util.List;

public interface IGeneralService<E> {

    List<E> findAll();

    E findById(Integer id);

    E save(E e);

    void deleteById(Integer id);
}
