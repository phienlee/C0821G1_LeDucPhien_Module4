package com.example.furama_resort.service.customer;


import com.example.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {

    Page<Customer> findAll(int pageNum, String sortField, String sortDir, String keyword);

    List<Customer> findAll();

    List<Customer> findByField(String name, String email);

    Customer findById(Integer id);

    Customer save(Customer customer);

    void deleteById(Integer id);
}
