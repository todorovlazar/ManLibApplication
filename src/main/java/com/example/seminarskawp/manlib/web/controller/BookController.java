package com.example.seminarskawp.manlib.web.controller;

import com.example.seminarskawp.manlib.model.*;
import com.example.seminarskawp.manlib.service.BookAuthorService;
import com.example.seminarskawp.manlib.service.BookRatingsService;
import com.example.seminarskawp.manlib.service.BookService;
import com.example.seminarskawp.manlib.service.LibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;
    private final BookAuthorService bookAuthorService;
    private final BookRatingsService bookRatingsService;
    private final LibraryService libraryService;

    public BookController(BookService bookService, BookAuthorService bookAuthorService, BookRatingsService bookRatingsService, LibraryService libraryService) {
        this.bookService = bookService;
        this.bookAuthorService = bookAuthorService;
        this.bookRatingsService = bookRatingsService;
        this.libraryService = libraryService;
    }

    @GetMapping("/books")
    public String showBooks(Model model,
                            String bookName,
                            BookType type){
        List<Book> bookList;
        BookType[] bookTypes = BookType.values();
        if(bookName==null || bookName.isEmpty() || type == null || type.toString().isEmpty()){
            bookList = this.bookService.findAll();
        } else {
            bookList = this.bookService.filterBooks(bookName, type);
        }
        model.addAttribute("bookList", bookList);
        model.addAttribute("bookTypes", bookTypes);
        return "bookList";
    }
    @GetMapping("/book/{id}/details")
    public String showDetailsBook(@PathVariable Long id,
                                        Model model){
        Book book = this.bookService.findById(id);
        List<Library> libraries = this.libraryService.findLibrariesByBook(book.getId());
        model.addAttribute("book", book);
        model.addAttribute("libraries", libraries);
        return "detailsBook";
    }
    @GetMapping("/books/add")
    public String showAddBooks(Model model){
        List<BookAuthor> bookAuthors = this.bookAuthorService.findAll();
        List<BookType> bookTypes = Arrays.asList(BookType.values());
        model.addAttribute("bookAuthors", bookAuthors);
        model.addAttribute("bookTypes", bookTypes);
        return "formBook";
    }
    @GetMapping("/books/{id}/edit")
    public String showEditBooks(@PathVariable Long id,
                                    Model model){
        List<BookAuthor> bookAuthors = this.bookAuthorService.findAll();
        List<BookType> bookTypes = Arrays.asList(BookType.values());
        Book book = this.bookService.findById(id);
        model.addAttribute("bookAuthors", bookAuthors);
        model.addAttribute("bookTypes", bookTypes);
        model.addAttribute("book", book);
        return "formBook";
    }
    @PostMapping("/books")
    public String createBook(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam String pictureUrl,
                             @RequestParam BookType bookType,
                             @RequestParam List<Long> bookAuthor){
        this.bookService.save(name, description, pictureUrl, bookType, bookAuthor);
        return "redirect:/books";
    }
    @PostMapping("/books/{id}")
    public String updateBook(@PathVariable Long id,
                             @RequestParam String name,
                             @RequestParam String description,
                             @RequestParam String pictureUrl,
                             @RequestParam BookType bookType,
                             @RequestParam List<Long> bookAuthor) {
        this.bookService.edit(id, name, description, pictureUrl, bookType, bookAuthor);
        return "redirect:/books";
    }
    @PostMapping("/books/{id}/delete")
    public String deleteBook(@PathVariable Long id){
        this.bookService.deleteById(id);
        return "redirect:/books";
    }
}
