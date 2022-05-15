package com.example.seminarskawp.manlib.repository;

import com.example.seminarskawp.manlib.model.BookRatings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRatingsRepository extends JpaRepository<BookRatings, Long> {
}
