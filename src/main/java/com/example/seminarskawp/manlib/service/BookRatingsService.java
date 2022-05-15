package com.example.seminarskawp.manlib.service;

import com.example.seminarskawp.manlib.model.Book;
import com.example.seminarskawp.manlib.model.BookRatings;
import com.example.seminarskawp.manlib.model.BookType;
import com.example.seminarskawp.manlib.model.User;

import java.util.List;

public interface BookRatingsService {

    List<BookRatings> findAll();

    BookRatings findById(Long id);

    BookRatings findByUser(User user);

    BookRatings save(Integer grade, User user);

    BookRatings edit(Long id, Integer grade, User user);

    void deleteById(Long id);

}
