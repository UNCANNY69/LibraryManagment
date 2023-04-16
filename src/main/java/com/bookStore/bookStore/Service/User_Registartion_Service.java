package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Model.Role;
import com.bookStore.bookStore.Model.User;
import com.bookStore.bookStore.Repository.UserRepository;
import com.bookStore.bookStore.Controller.Dto.UserRegistrationDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class User_Registartion_Service {

    private final UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder;

    public User_Registartion_Service(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }


    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(), registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()), List.of(new Role("ROLE_USER")));
        return userRepository.save(user);
    }




}
