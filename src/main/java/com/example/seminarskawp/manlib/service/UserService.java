package com.example.seminarskawp.manlib.service;

import com.example.seminarskawp.manlib.model.Library;
import com.example.seminarskawp.manlib.model.LibraryCoordinates;
import com.example.seminarskawp.manlib.model.User;
import com.example.seminarskawp.manlib.model.UserType;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User registerUser(String username, String email, String password, String repeatPassword);

    List<User> findAll();

    List<User> filterUser(String usernameFilter);

    User findById(Long id);

    User findByUsername(String username);

    User edit(Long id, String email, String username, UserType userType, List<Long> books);

    void deleteById(Long id);

}
