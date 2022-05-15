package com.example.seminarskawp.manlib.service;

import com.example.seminarskawp.manlib.model.User;

public interface AuthService {

    User login(String username, String password);
}
