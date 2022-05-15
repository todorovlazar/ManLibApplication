package com.example.seminarskawp.manlib.web.controller;

import com.example.seminarskawp.manlib.model.Book;
import com.example.seminarskawp.manlib.model.Library;
import com.example.seminarskawp.manlib.model.LibraryCoordinates;
import com.example.seminarskawp.manlib.model.User;
import com.example.seminarskawp.manlib.service.BookService;
import com.example.seminarskawp.manlib.service.LibraryService;
import com.example.seminarskawp.manlib.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class LibraryController {

    private final LibraryService libraryService;
    private final BookService bookService;
    private final UserService userService;

    public LibraryController(LibraryService libraryService, BookService bookService, UserService userService) {
        this.libraryService = libraryService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/libraries/map")
    public ModelAndView showLibrariesMap(Model model) throws JsonProcessingException {
            ModelAndView result = new ModelAndView("libraryMap");
            List<Library> libraries = this.libraryService.findAll();
            ObjectMapper Obj = new ObjectMapper();
            String librariesJson = Obj.writeValueAsString(libraries);
            //System.out.println(librariesJson);
            result.addObject("libraries", librariesJson);
            return result;
    }

    @GetMapping("/libraries")
    public String showLibraries(Model model){
        List<Library> libraryList = this.libraryService.findAll();
        model.addAttribute("libraryList", libraryList);
        return "libraryList";
    }
    @GetMapping("/libraries/add")
    public String showAddLibraries(Model model){
        List<Book> books = this.bookService.findAll();
        List<User> users = this.userService.findAll();
        model.addAttribute("books", books);
        model.addAttribute("users", users);
        return "formLibrary";
    }
    @GetMapping("/libraries/{id}/edit")
    public String showEditLibraries(@PathVariable Long id,
                                    Model model){
        Library library = this.libraryService.findById(id);
        List<Book> books = this.bookService.findAll();
        List<User> users = this.userService.findAll();
        model.addAttribute("books", books);
        model.addAttribute("library", library);
        model.addAttribute("users", users);
        return "formLibrary";
    }
    @PostMapping("/libraries")
    public String createLibrary(@RequestParam String name,
                         @RequestParam String location,
                         @RequestParam Double lang,
                         @RequestParam Double lat,
                         @RequestParam List<Long> books,
                         @RequestParam List<Long> users){
        LibraryCoordinates coordinates = new LibraryCoordinates(lang, lat);
        this.libraryService.save(name, location,  coordinates, books, users);
        return "redirect:/libraries";
    }
    @PostMapping("/libraries/{id}")
    public String updateLibrary(@PathVariable Long id,
                                @RequestParam String name,
                                @RequestParam String location,
                                @RequestParam Double lang,
                                @RequestParam Double lat,
                                @RequestParam List<Long> books,
                                @RequestParam(required = false) List<Long> users) {
        LibraryCoordinates coordinates = new LibraryCoordinates(lang, lat);
        this.libraryService.edit(id, name, location, coordinates, books, users);
        return "redirect:/libraries";
    }
    @PostMapping("/libraries/{id}/delete")
    public String deleteLibrary(@PathVariable Long id){
        this.libraryService.deleteById(id);
        return "redirect:/libraries";
    }
}
