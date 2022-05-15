package com.example.seminarskawp.manlib.repository;

import com.example.seminarskawp.manlib.model.Book;
import com.example.seminarskawp.manlib.model.BookAuthor;
import com.example.seminarskawp.manlib.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByNameLike(String name);
    List<Book> findAllByBookAuthorContains(BookAuthor bookAuthor);
    List<Book> findAllByNameContainingAndBookType(String bookName, BookType type);
    List<Book> findAllByNameContaining(String bookName);
    List<Book> findAllByBookType(BookType type);

}
