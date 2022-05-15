package com.example.seminarskawp.manlib.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserType implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_USER;


    @Override
    public String getAuthority() {
        return name();
    }
}
