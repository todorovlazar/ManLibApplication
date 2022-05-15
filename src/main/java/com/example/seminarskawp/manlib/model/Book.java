package com.example.seminarskawp.manlib.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 10000)
    private String description;

    private String pictureUrl;

    @Enumerated(value = EnumType.STRING)
    private BookType bookType;

    @ManyToMany
    private List<BookAuthor> bookAuthor;

    @ManyToMany
    private List<BookRatings> bookRatings;


    public Book() {

    }

    public Book(String name, String description, String pictureUrl, BookType bookType, List<BookAuthor> bookAuthor, List<BookRatings> bookRatings){
        this.name = name;
        this.description = description;
        this.pictureUrl = pictureUrl;
        this.bookType = bookType;
        this.bookAuthor = bookAuthor;
        this.bookRatings = bookRatings;
    }
    public Book(String name, String description, String pictureUrl, BookType bookType, List<BookAuthor> bookAuthor){
        this.name = name;
        this.description = description;
        this.pictureUrl = pictureUrl;
        this.bookType = bookType;
        this.bookAuthor = bookAuthor;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public List<BookAuthor> getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(List<BookAuthor> bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public List<BookRatings> getBookRatings() {
        return bookRatings;
    }

    public void setBookRatings(List<BookRatings> bookRatings) {
        this.bookRatings = bookRatings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
