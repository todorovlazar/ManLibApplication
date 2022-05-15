package com.example.seminarskawp.manlib.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class BookRatings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private Integer grade;

    public BookRatings() {
    }

    public BookRatings(Long id, Integer grade, User user) {
        this.id = id;
        this.grade = grade;
        this.user = user;
    }
    public BookRatings(Integer grade, User user){
        this.grade = grade;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
