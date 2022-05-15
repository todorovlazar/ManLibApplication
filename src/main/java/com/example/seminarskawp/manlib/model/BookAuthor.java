package com.example.seminarskawp.manlib.model;

import javax.persistence.*;

@Entity
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "BookId")
    private Long id;

    private String name;
    private String surname;
    @Column(length = 10000)
    private String details;
    private String pictureUrl;

    public BookAuthor(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public BookAuthor(String name, String surname, String details, String pictureUrl){
        this.name = name;
        this.surname = surname;
        this.details = details;
        this.pictureUrl = pictureUrl;
    }

    public BookAuthor() {
    }

    public BookAuthor(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullName (){
        return name+" "+surname;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
