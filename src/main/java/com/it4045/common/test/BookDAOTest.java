package com.it4045.common.test;

import com.it4045.common.dao.BookDAO;
import com.it4045.common.dto.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookDAOTest {
    BookDAO bookDAO;
    @Before
    public void setUp() throws Exception {
        bookDAO= new BookDAO();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAllBooks() throws Exception {
        assert(bookDAO.getAllBooks().size() == 1);
    }

    @Test
    public void testGetBookById() throws Exception {
        assert(bookDAO.getBookById(1).getTitle().equalsIgnoreCase("The Lord Of The Rings"));
    }

    @Test
    public void testAddBook() throws Exception {

        Book book = new Book();
        book.setTitle("The Lord Of The Rings");
        book.setAuthor("Tolken");
        book.setSubject("Fantasy");
        book.setPublisher("I Do'nt know");

        bookDAO.addBook(book);
    }

    @Test
    public void testUpdateBook() throws Exception {
        Book book = new Book();
        book.setTitle("The Lord Of The Rings");
        book.setAuthor("Tolken");
        bookDAO.updateBook(book);
    }

    @Test
    public void testDeleteBook() throws Exception {
        Book book = bookDAO.getBookById(1);
        bookDAO.deleteBook(book);
    }
}
