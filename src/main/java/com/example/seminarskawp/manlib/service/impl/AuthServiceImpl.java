package com.example.seminarskawp.manlib.service.impl;

import com.example.seminarskawp.manlib.exceptions.InvalidArgumentsException;
import com.example.seminarskawp.manlib.exceptions.InvalidUserCredentialsException;
import com.example.seminarskawp.manlib.model.User;
import com.example.seminarskawp.manlib.repository.UserRepository;
import com.example.seminarskawp.manlib.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }
}
