package com.alish.blog_spring.services;

import com.alish.blog_spring.dtos.RegistrationUserDTO;
import com.alish.blog_spring.exceptions.UserAlreadyExistException;
import com.alish.blog_spring.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    User registerNewUserAccount(RegistrationUserDTO userDto) throws UserAlreadyExistException;

    User getUserById(Long id);

    List<User> getAllUsers();

    User getCurrentUser();

    User saveUser(User user);
}