package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Controller.Dto.UserRegistrationDto;
import com.bookStore.bookStore.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface User_Registration_Interface extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
