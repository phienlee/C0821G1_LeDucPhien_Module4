package com.example.furama_resort.service.contract.impl;

import com.example.furama_resort.model.contract.AttachService;
import com.example.furama_resort.repository.contract.AttachServiceRepository;
import com.example.furama_resort.service.contract.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImpl implements AttachServiceService {

    @Autowired
    private AttachServiceRepository repository;

    @Override
    public List<AttachService> findAll() {
        return repository.findAll();
    }

    @Override
    public AttachService findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AttachService save(AttachService attachService) {
        return repository.save(attachService);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
