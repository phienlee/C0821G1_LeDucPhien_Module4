package com.example.furama_resort.service.contract.impl;

import com.example.furama_resort.model.contract.Contract;
import com.example.furama_resort.repository.contract.ContractRepository;
import com.example.furama_resort.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository repository;

    @Override
    public List<Contract> findAll() {
        return repository.findAll();
    }

    @Override
    public Contract findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Contract save(Contract contract) {
        return repository.save(contract);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
