package com.maybanktask.user_management.dao;

import jakarta.persistence.*;

@Entity
public class CustomerDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String title;
    private int age;
    @OneToOne(mappedBy = "customerDetailsEntity")
    private Booksource booksource;

    public CustomerDetailsEntity() {
    }

    public CustomerDetailsEntity(Long id, String name, String title, int age) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.age = age;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Booksource getBooksource() {
        return booksource;
    }

    public void setBooksource(Booksource booksource) {
        this.booksource = booksource;
    }
}
