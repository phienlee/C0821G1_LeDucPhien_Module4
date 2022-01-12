package com.example.furama_resort.service.employee.impl;

import com.example.furama_resort.model.employee.Position;
import com.example.furama_resort.repository.employee.PositionRepository;
import com.example.furama_resort.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findById(Integer id) {
        return positionRepository.findById(id).orElse(null);
    }

    @Override
    public Position save(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public void deleteById(Integer id) {
        positionRepository.deleteById(id);
    }
}
