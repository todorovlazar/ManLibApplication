package com.example.seminarskawp.manlib.service.impl;

import com.example.seminarskawp.manlib.exceptions.BookRatingNotFoundException;
import com.example.seminarskawp.manlib.model.BookRatings;
import com.example.seminarskawp.manlib.model.User;
import com.example.seminarskawp.manlib.repository.BookRatingsRepository;
import com.example.seminarskawp.manlib.repository.UserRepository;
import com.example.seminarskawp.manlib.service.BookRatingsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRatingsServiceImpl implements BookRatingsService {

    private final BookRatingsRepository bookRatingsRepository;
    private final UserRepository userRepository;

    public BookRatingsServiceImpl(BookRatingsRepository bookRatingsRepository, UserRepository userRepository) {
        this.bookRatingsRepository = bookRatingsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<BookRatings> findAll() {
        return this.bookRatingsRepository.findAll();
    }

    @Override
    public BookRatings findById(Long id) {
        return this.bookRatingsRepository.findById(id).orElseThrow(()-> new BookRatingNotFoundException(id));
    }

    @Override
    public BookRatings findByUser(User user) {
        return null;
    }

    @Override
    public BookRatings save(Integer grade, User user) {
        BookRatings bookRatings = new BookRatings(grade, user);
        return this.bookRatingsRepository.save(bookRatings);
    }

    @Override
    public BookRatings edit(Long id, Integer grade, User user) {
        BookRatings bookRatings = this.findById(id);
        bookRatings.setGrade(grade); bookRatings.setUser(user);
        return this.bookRatingsRepository.save(bookRatings);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRatingsRepository.deleteById(id);
    }
}
