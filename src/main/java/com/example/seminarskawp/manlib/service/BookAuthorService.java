package com.example.seminarskawp.manlib.service;

import com.example.seminarskawp.manlib.model.Book;
import com.example.seminarskawp.manlib.model.BookAuthor;
import com.example.seminarskawp.manlib.model.BookType;

import java.util.List;
import java.util.Optional;

public interface BookAuthorService {

    List<BookAuthor> findAll();

    List<BookAuthor> filterAuthors(String name, String surname);

    BookAuthor findById(Long id);

    BookAuthor findByName(String name);

    BookAuthor save(String name, String surname, String details, String pictureUrl);

    BookAuthor edit(Long id, String name, String surname, String details, String pictureUrl);

    void deleteById(Long id);

}
