package com.it4045.common.dto;

/**
 * A class to represent a Book, in real life.
 * Used by the UserDAO class to manipulate corresponding
 * data
 */
public class Book {
    Integer id;
    String title;
    String author;
    String subject;
    String publisher;


    public Book() {
    }

    public Book(Integer id, String title, String author, String subject, String publisher) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.publisher = publisher;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return publisher;
    }

    public void setDescription(String publisher) {
        this.publisher = publisher;
    }

}
