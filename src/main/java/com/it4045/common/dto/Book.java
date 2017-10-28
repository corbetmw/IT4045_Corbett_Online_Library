package com.it4045.common.dto;

/**
 * A class to represent a Book, in real life.
 * Used by the UserDAO class to manipulate corresponding
 * data
 */
public class Book {
    private Integer id;
    private String title;
    private String author;
    private String status;
    private String description;


    public Book() {
    }

    public Book(Integer id, String title, String author, String status, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = status;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
