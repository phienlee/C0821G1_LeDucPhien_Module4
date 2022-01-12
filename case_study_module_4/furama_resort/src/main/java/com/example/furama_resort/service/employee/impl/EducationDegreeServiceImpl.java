package com.example.furama_resort.service.employee.impl;

import com.example.furama_resort.model.employee.EducationDegree;
import com.example.furama_resort.repository.employee.EducationDegreeRepository;
import com.example.furama_resort.service.employee.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    private EducationDegreeRepository repository;

    @Override
    public List<EducationDegree> findAll() {
        return repository.findAll();
    }

    @Override
    public EducationDegree findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public EducationDegree save(EducationDegree educationDegree) {
        return repository.save(educationDegree);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
