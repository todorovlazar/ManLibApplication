package com.example.seminarskawp.manlib.service.impl;

import com.example.seminarskawp.manlib.exceptions.BookAuthorNotFoundException;
import com.example.seminarskawp.manlib.model.BookAuthor;
import com.example.seminarskawp.manlib.repository.BookAuthorRepository;
import com.example.seminarskawp.manlib.service.BookAuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookAuthorServiceImpl implements BookAuthorService {

    private final BookAuthorRepository bookAuthorRepository;

    public BookAuthorServiceImpl(BookAuthorRepository bookAuthorRepository) {
        this.bookAuthorRepository = bookAuthorRepository;
    }

    @Override
    public List<BookAuthor> findAll() {
        return this.bookAuthorRepository.findAll();
    }

    @Override
    public List<BookAuthor> filterAuthors(String name, String surname) {
        if(name!=null && surname!=null){
            return this.bookAuthorRepository.findAllByNameContainingAndSurnameContaining(name, surname);
        } else if(name!=null && surname==null){
            return this.bookAuthorRepository.findAllByNameContaining(name);
        } else if(name==null && surname!=null){
            return this.bookAuthorRepository.findAllBySurnameContaining(surname);
        } else {
            return this.bookAuthorRepository.findAll();
        }
    }

    @Override
    public BookAuthor findById(Long id) {
        return this.bookAuthorRepository.findById(id).orElseThrow(() -> new BookAuthorNotFoundException(id));
    }

    @Override
    public BookAuthor findByName(String name) {
        return this.bookAuthorRepository.findByNameLike(name).orElseThrow(() -> new BookAuthorNotFoundException(name));
    }

    @Override
    public BookAuthor save(String name, String surname, String details, String pictureUrl) {
        BookAuthor bookAuthor = new BookAuthor(name, surname, details, pictureUrl);
        return this.bookAuthorRepository.save(bookAuthor);
    }

    @Override
    public BookAuthor edit(Long id, String name, String surname, String details, String pictureUrl) {
        BookAuthor bookAuthor = this.findById(id);
        bookAuthor.setName(name); bookAuthor.setSurname(surname); bookAuthor.setDetails(details);
        bookAuthor.setPictureUrl(pictureUrl);
        return this.bookAuthorRepository.save(bookAuthor);
    }

    @Override
    public void deleteById(Long id) {
        this.bookAuthorRepository.deleteById(id);
    }
}
