package com.example.furama_resort.service.service_hotel.service_hotel_impl;

import com.example.furama_resort.model.service_hotel.RentalType;
import com.example.furama_resort.repository.service_hotel.RentalTypeRepository;
import com.example.furama_resort.service.service_hotel.RentalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalTypeServiceImpl implements RentalTypeService {
    @Autowired
    private RentalTypeRepository repository;

    @Override
    public List<RentalType> findAll() {
        return repository.findAll();
    }

    @Override
    public RentalType findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public RentalType save(RentalType rentalType) {
        return repository.save(rentalType);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
