package com.it4045.common.dto;

public class Book {
    private int id;
    private String title;
    private String author;
    private String status;
    private String description;


    public Book() {
    }

    public Book(int id, String title, String author, String status, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = status;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}