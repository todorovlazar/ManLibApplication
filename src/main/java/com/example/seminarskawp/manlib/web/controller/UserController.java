package com.example.seminarskawp.manlib.web.controller;

import com.example.seminarskawp.manlib.model.*;
import com.example.seminarskawp.manlib.service.BookService;
import com.example.seminarskawp.manlib.service.LibraryService;
import com.example.seminarskawp.manlib.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final LibraryService libraryService;
    private final BookService bookService;

    public UserController(UserService userService, LibraryService libraryService, BookService bookService) {
        this.userService = userService;
        this.libraryService = libraryService;
        this.bookService = bookService;
    }

    @GetMapping("/users")
    public String showUsers(String usernameFilter,
                            Model model){
        List<User> users;
        if(usernameFilter == null || usernameFilter.isEmpty()){
            users = this.userService.findAll();
        } else {
            users = this.userService.filterUser(usernameFilter);
        }
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/users/{id}/edit")
    public String showEditUser(@PathVariable Long id,
                                    Model model){
        User user = this.userService.findById(id);
        List<Book> books = this.bookService.findAll();
        UserType[] userTypes = UserType.values();
        model.addAttribute("books", books);
        model.addAttribute("user", user);
        model.addAttribute("userTypes", userTypes);
        return "formUser";
    }
    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable Long id,
                                @RequestParam String email,
                                @RequestParam String username,
                                @RequestParam UserType userType,
                                @RequestParam List<Long> books) {
        this.userService.edit(id, email, username, userType, books);
        return "redirect:/users";
    }
    @PostMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable Long id){
        this.userService.deleteById(id);
        return "redirect:/users";
    }
}
