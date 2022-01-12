package com.example.furama_resort.service.employee.impl;

import com.example.furama_resort.model.employee.Employee;
import com.example.furama_resort.repository.employee.EmployeeRepository;
import com.example.furama_resort.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
