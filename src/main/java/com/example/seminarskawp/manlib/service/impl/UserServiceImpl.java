package com.example.seminarskawp.manlib.service.impl;

import com.example.seminarskawp.manlib.exceptions.InvalidUsernameOrPasswordException;
import com.example.seminarskawp.manlib.exceptions.PasswordsDoNotMatchException;
import com.example.seminarskawp.manlib.exceptions.UserAlreadyExistException;
import com.example.seminarskawp.manlib.exceptions.UserNotFoundException;
import com.example.seminarskawp.manlib.model.Book;
import com.example.seminarskawp.manlib.model.User;
import com.example.seminarskawp.manlib.model.UserType;
import com.example.seminarskawp.manlib.repository.BookRepository;
import com.example.seminarskawp.manlib.repository.UserRepository;
import com.example.seminarskawp.manlib.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BookRepository bookRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(String username, String email, String password, String repeatPassword) {
        UserType userType = UserType.ROLE_USER;
        if(this.userRepository.findByEmail(email).isPresent()){
            throw new UserAlreadyExistException(email);
        }
        if(username == null || username.isEmpty() || password == null || password.isEmpty()){
            throw new InvalidUsernameOrPasswordException();
        }
        if(!password.equals(repeatPassword)){
            throw new PasswordsDoNotMatchException();
        }
        User newUser = new User(email, username, passwordEncoder.encode(password), userType);
        return this.userRepository.save(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow( () -> new UsernameNotFoundException(username));
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public List<User> filterUser(String usernameFilter) {
        if(usernameFilter!=null){
            return this.userRepository.findUsersByUsernameContaining(usernameFilter);
        } else {
            return this.userRepository.findAll();
        }
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsernameLike(username).orElseThrow(()-> new UserNotFoundException(username));
    }

    @Override
    public User edit(Long id, String email, String username, UserType userType, List<Long> books) {
        List<Book> bookList = this.bookRepository.findAllById(books);
        User user = this.findById(id);
        user.setEmail(email); user.setUsername(username);
        user.setUserType(userType); user.setBooks(bookList);
        return this.userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }
}
