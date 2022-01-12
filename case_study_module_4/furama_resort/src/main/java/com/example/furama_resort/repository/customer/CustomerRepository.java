package com.example.furama_resort.repository.customer;

import com.example.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
    Page<Customer> findByNameContaining(String keyword, Pageable pageable);
    List<Customer> findByNameContaining(String nameSearch);
    List<Customer> findByEmailContaining(String emailSearch);
    List<Customer> findByAddressContaining(String address);
    List<Customer> findByNameContainingAndEmailContaining(String nameSearch, String emailSearch);
}
