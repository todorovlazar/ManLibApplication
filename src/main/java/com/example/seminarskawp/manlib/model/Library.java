package com.example.seminarskawp.manlib.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_library")
    private String name;

    @Column(name = "location_library")
    private String location;

    @Embedded
    private LibraryCoordinates coordinates;

    @ManyToMany
    private List<Book> books;

    @ManyToMany
    private List<User> users;

    public Library() {
    }

    public Library(Long id, String name, String location, LibraryCoordinates coordinates, List<Book> books, List<User> users) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.coordinates = coordinates;
        this.books = books;
        this.users = users;
    }
    public Library(String name, String location, LibraryCoordinates coordinates, List<Book> books, List<User> users){
        this.name = name;
        this.location = location;
        this.coordinates = coordinates;
        this.books = books;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LibraryCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(LibraryCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
