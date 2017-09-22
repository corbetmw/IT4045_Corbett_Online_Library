package com.it4045.common.dao;

import com.it4045.common.dto.Book;

import java.util.ArrayList;
import java.util.List;

public interface IBookDAO {

    public List<Book> getAllBooks();
    public void addBook(Book book);
    public void deleteBook(Book book);
    public void updateBook(Book book);
    
}
