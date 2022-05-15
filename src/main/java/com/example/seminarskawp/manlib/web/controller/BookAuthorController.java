package com.example.seminarskawp.manlib.web.controller;

import com.example.seminarskawp.manlib.model.Book;
import com.example.seminarskawp.manlib.model.BookAuthor;
import com.example.seminarskawp.manlib.service.BookAuthorService;
import com.example.seminarskawp.manlib.service.BookService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookAuthorController {

    private final BookAuthorService bookAuthorService;
    private final BookService bookService;

    public BookAuthorController(BookAuthorService bookAuthorService, BookService bookService) {
        this.bookAuthorService = bookAuthorService;
        this.bookService = bookService;
    }

    @GetMapping("/bookAuthors")
    public String showBookAuthors(Model model,
                                  @RequestParam(required = false) String name,
                                  @RequestParam(required = false) String surname){
        List<BookAuthor> bookAuthors;
        if(name==null || name.isEmpty() || surname==null || surname.isEmpty()){
            bookAuthors = this.bookAuthorService.findAll();
        } else {
            bookAuthors = this.bookAuthorService.filterAuthors(name, surname);
        }
        model.addAttribute("bookAuthors", bookAuthors);
        return "bookAuthorList";
    }
    @GetMapping("/bookAuthors/add")
    public String showAddBookAuthors(){
        return "formBookAuthor";
    }
    @GetMapping("/bookAuthors/{id}/edit")
    public String showEditBooks(@PathVariable Long id,
                                Model model){
        BookAuthor bookAuthor = this.bookAuthorService.findById(id);
        model.addAttribute("bookAuthor", bookAuthor);
        return "formBookAuthor";
    }
    @GetMapping("/bookAuthors/{id}/details")
    public String showDetailsBookAuthor(@PathVariable Long id,
                                        Model model){
        BookAuthor bookAuthor = this.bookAuthorService.findById(id);
        List<Book> bookList = this.bookService.findByBookAuthor(bookAuthor.getId());
        model.addAttribute("bookAuthor", bookAuthor);
        model.addAttribute("bookList", bookList);
        return "detailsBookAuthor";
    }
    @PostMapping("/bookAuthors")
    public String createBook(@RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam String details,
                             @RequestParam String pictureUrl){
        this.bookAuthorService.save(name, surname, details, pictureUrl);
        return "redirect:/bookAuthors";
    }
    @PostMapping("/bookAuthors/{id}")
    public String updateBook(@PathVariable Long id,
                             @RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam String details,
                             @RequestParam String pictureUrl) {
        this.bookAuthorService.edit(id, name, surname, details, pictureUrl);
        return "redirect:/bookAuthors";
    }
    @PostMapping("/bookAuthors/{id}/delete")
    public String deleteBook(@PathVariable Long id){
        this.bookAuthorService.deleteById(id);
        return "redirect:/bookAuthors";
    }
}
