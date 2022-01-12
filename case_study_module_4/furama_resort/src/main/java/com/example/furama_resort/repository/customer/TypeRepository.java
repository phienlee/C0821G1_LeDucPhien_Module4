package com.example.furama_resort.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type,Integer> {
}
