package com.example.furama_resort.service.customer.impl;

import com.example.furama_resort.repository.customer.TypeRepository;
import com.example.furama_resort.service.customer.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository repository;

    @Override
    public List<Type> findAll() {
        return repository.findAll();
    }

    @Override
    public Type findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Type save(Type type) {
        return repository.save(type);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
