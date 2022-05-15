package com.example.seminarskawp.manlib.service.impl;

import com.example.seminarskawp.manlib.exceptions.BookAuthorNotFoundException;
import com.example.seminarskawp.manlib.exceptions.BookNotFoundException;
import com.example.seminarskawp.manlib.model.Book;
import com.example.seminarskawp.manlib.model.BookAuthor;
import com.example.seminarskawp.manlib.model.BookRatings;
import com.example.seminarskawp.manlib.model.BookType;
import com.example.seminarskawp.manlib.repository.BookAuthorRepository;
import com.example.seminarskawp.manlib.repository.BookRatingsRepository;
import com.example.seminarskawp.manlib.repository.BookRepository;
import com.example.seminarskawp.manlib.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookAuthorRepository bookAuthorRepository;
    private final BookRatingsRepository bookRatingsRepository;

    public BookServiceImpl(BookRepository bookRepository, BookAuthorRepository bookAuthorRepository, BookRatingsRepository bookRatingsRepository) {
        this.bookRepository = bookRepository;
        this.bookAuthorRepository = bookAuthorRepository;
        this.bookRatingsRepository = bookRatingsRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public List<Book> filterBooks(String bookName, BookType type) {
        if(bookName!=null && type!=null){
            return this.bookRepository.findAllByNameContainingAndBookType(bookName, type);
        } else if(bookName!=null && type==null){
            return this.bookRepository.findAllByNameContaining(bookName);
        } else if(bookName==null && type!=null){
            return this.bookRepository.findAllByBookType(type);
        } else {
            return this.findAll();
        }
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
    }

    @Override
    public Book findByName(String name) {
        return this.bookRepository.findByNameLike(name).orElseThrow(()-> new BookNotFoundException(name));
    }

    @Override
    public List<Book> findByBookAuthor(Long authorId){
        BookAuthor bookAuthor = this.bookAuthorRepository.findById(authorId).orElseThrow(() -> new BookAuthorNotFoundException(authorId));
        return this.bookRepository.findAllByBookAuthorContains(bookAuthor);
    }

    @Override
    public Book save(String name, String description, String pictureUrl, BookType type, List<Long> authors) {
        List<BookAuthor> bookAuthors = this.bookAuthorRepository.findAllById(authors);
//        List<BookRatings> bookRatings = this.bookRatingsRepository.findAllById(ratings);
        Book book = new Book(name, description, pictureUrl, type, bookAuthors);
        return this.bookRepository.save(book);
    }

    @Override
    public Book edit(Long id, String name, String description, String pictureUrl, BookType type, List<Long> authors) {
        List<BookAuthor> bookAuthors = this.bookAuthorRepository.findAllById(authors);
//        List<BookRatings> bookRatings = this.bookRatingsRepository.findAllById(ratings);
        Book book = this.bookRepository.findById(id).orElseThrow( () -> new BookNotFoundException(id));
        book.setName(name); book.setBookType(type); book.setBookAuthor(bookAuthors);
        book.setDescription(description); book.setPictureUrl(pictureUrl);
//        book.setBookRatings(bookRatings);
        return this.bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
