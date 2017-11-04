package com.it4045.common.service;

import com.it4045.common.dao.BookDAO;
import com.it4045.common.dto.Book;

import java.io.IOException;

/**
 * A class that allows Beans to interact with the
 * BookDAO class
 */
public class BookService {

    BookDAO bookDAO;

    public BookService() {
        try {
            this.bookDAO = new BookDAO();
        } catch (IOException e) {
            System.out.print("Unable to create new book DAO");
        }
    }

    /**
     * Implements the BookDAO addBook method
     *
     * @param book
     * @throws Exception
     */
    public void createBook(Book book) {
        try {
            this.bookDAO.addBook(book);
        } catch (Exception e) {
            System.out.print("Unable to create new book DAO");
        }
    }

}
