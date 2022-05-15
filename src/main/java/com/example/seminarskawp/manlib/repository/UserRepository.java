package com.example.seminarskawp.manlib.repository;

import com.example.seminarskawp.manlib.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameLike(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByEmail(String email);

    Optional<UserDetails> findByUsername(String username);

    List<User> findUsersByUsernameContaining(String usernameFilter);
}
