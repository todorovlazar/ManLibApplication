package com.example.seminarskawp.manlib.repository;

import com.example.seminarskawp.manlib.model.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {

    Optional<BookAuthor> findByNameLike(String name);
    List<BookAuthor> findAllByNameContaining(String name);
    List<BookAuthor> findAllBySurnameContaining(String surname);
    List<BookAuthor> findAllByNameContainingAndSurnameContaining(String name, String surname);
}
