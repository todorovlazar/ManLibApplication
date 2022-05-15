package com.example.seminarskawp.manlib.repository;

import com.example.seminarskawp.manlib.model.Book;
import com.example.seminarskawp.manlib.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

    Optional<Library> findByNameLike(String name);
    List<Library> findAllByBooksContains(Book book);

}
