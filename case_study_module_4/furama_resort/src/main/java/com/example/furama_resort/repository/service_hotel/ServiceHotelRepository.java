package com.example.furama_resort.repository.service_hotel;

import com.example.furama_resort.model.service_hotel.ServiceHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceHotelRepository extends JpaRepository<ServiceHotel, Integer> {
}
