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

    public BookService() throws IOException {
        this.bookDAO = new BookDAO();
    }

    /**
     * Implements the BookDAO addBook method
     * @param book
     * @throws Exception
     */
    public void createBook(Book book) throws Exception {
        this.bookDAO.addBook(book);
    }

}
