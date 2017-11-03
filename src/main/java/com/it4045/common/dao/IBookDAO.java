package com.it4045.common.dao;

import com.it4045.common.dto.Book;

import java.util.ArrayList;
import java.util.List;

public interface IBookDAO {

    public List<Book> getAllBooks() throws Exception;
    public void addBook(Book book) throws Exception;
    public void deleteBook(Book book) throws Exception;
    public void updateBook(Book book) throws Exception;
    
}
