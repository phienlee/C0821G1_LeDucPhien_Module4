package com.example.furama_resort.service.service_hotel.service_hotel_impl;

import com.example.furama_resort.model.service_hotel.ServiceHotel;
import com.example.furama_resort.repository.service_hotel.ServiceHotelRepository;
import com.example.furama_resort.service.service_hotel.ServiceHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceHotelServiceImpl implements ServiceHotelService {
    @Autowired
    private ServiceHotelRepository repository;

    @Override
    public List<ServiceHotel> findAll() {
        return repository.findAll();
    }

    @Override
    public ServiceHotel findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ServiceHotel save(ServiceHotel serviceHotel) {
        return repository.save(serviceHotel);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
