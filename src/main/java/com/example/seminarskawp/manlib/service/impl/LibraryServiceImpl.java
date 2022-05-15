package com.example.seminarskawp.manlib.service.impl;

import com.example.seminarskawp.manlib.exceptions.BookNotFoundException;
import com.example.seminarskawp.manlib.exceptions.LibraryNotFoundException;
import com.example.seminarskawp.manlib.model.Book;
import com.example.seminarskawp.manlib.model.Library;
import com.example.seminarskawp.manlib.model.LibraryCoordinates;
import com.example.seminarskawp.manlib.model.User;
import com.example.seminarskawp.manlib.repository.BookRepository;
import com.example.seminarskawp.manlib.repository.LibraryRepository;
import com.example.seminarskawp.manlib.repository.UserRepository;
import com.example.seminarskawp.manlib.service.LibraryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public LibraryServiceImpl(LibraryRepository libraryRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.libraryRepository = libraryRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Library> findAll() {
        return this.libraryRepository.findAll();
    }

    @Override
    public Library findById(Long id) {
        return this.libraryRepository.findById(id).orElseThrow(()-> new LibraryNotFoundException(id));
    }

    @Override
    public Library findByName(String name) {
        return this.libraryRepository.findByNameLike(name).orElseThrow(()-> new LibraryNotFoundException(name));
    }

    @Override
    public List<Library> findLibrariesByBook(Long bookId){
        Book book = this.bookRepository.findById(bookId).orElseThrow(()-> new BookNotFoundException(bookId));
        return this.libraryRepository.findAllByBooksContains(book);
    }

    @Override
    public Library save(String name, String location, LibraryCoordinates coordinates, List<Long> books, List<Long> users) {
        List<Book> bookList = this.bookRepository.findAllById(books);
        List<User> userList = this.userRepository.findAllById(users);
        Library library = new Library(name, location, coordinates, bookList, userList);
        return this.libraryRepository.save(library);
    }

    @Override
    public Library edit(Long id, String name, String location, LibraryCoordinates coordinates, List<Long> books, List<Long> users) {
        List<Book> bookList = this.bookRepository.findAllById(books);
        List<User> userList = this.userRepository.findAllById(users);
        Library library = this.libraryRepository.findById(id).orElseThrow( () -> new LibraryNotFoundException(id));
        library.setName(name); library.setLocation(location); library.setCoordinates(coordinates);
        library.setBooks(bookList); library.setUsers(userList);
        return this.libraryRepository.save(library);
    }

    @Override
    public void deleteById(Long id) {
        this.libraryRepository.deleteById(id);
    }
}
