package com.example.seminarskawp.manlib.service;

import com.example.seminarskawp.manlib.model.Book;
import com.example.seminarskawp.manlib.model.BookType;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    List<Book> filterBooks(String bookName, BookType type);

    Book findById(Long id);

    Book findByName(String name);

    Book save(String name, String description, String pictureUrl, BookType type, List<Long> authors); // List<Long> bookRatings

    Book edit(Long id, String name, String description, String picutreUrl, BookType type, List<Long> authors); // List<Long> ratings

    void deleteById(Long id);

    List<Book> findByBookAuthor(Long authorId);

}
