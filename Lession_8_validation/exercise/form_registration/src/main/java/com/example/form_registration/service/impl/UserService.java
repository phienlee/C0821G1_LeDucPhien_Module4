package com.example.form_registration.service.impl;

import com.example.form_registration.dto.UserDTO;
import com.example.form_registration.model.User;
import com.example.form_registration.repository.IUserRepository;
import com.example.form_registration.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserService implements IUserService {

    @Autowired
    @Qualifier(value = "IUserRepository")
    IUserRepository iUserRepository;

    @Override
    public void save(UserDTO userDTO) {
        User form = new User(userDTO.getId(),userDTO.getFirstName(),userDTO.getLastName(),userDTO.getAge(),userDTO.getPhoneNumber(),userDTO.getEmail());
        iUserRepository.save(form);
    }
}
