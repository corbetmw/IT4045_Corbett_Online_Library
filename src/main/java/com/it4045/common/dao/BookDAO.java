package com.it4045.common.dao;

import com.it4045.common.dto.Book;
import com.it4045.common.utility.HibernateUtility;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;

/**
 * This class uses the Book object to manipulate data in the
 * mySQL database that this application is integrated with
 */
public class BookDAO implements IBookDAO {

    public BookDAO() throws IOException {

    }

    /**
     * Get all books from the mySQL database
     * in the form of a list of Book objects
     * @return <Book></>
     */
    public List<Book> getAllBooks() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<Book> bookList = session.createCriteria(Book.class).list();
        session.close();
        return bookList;
    }

    public Book getBookById(int id){
        Session session = HibernateUtility.getSessionFactory().openSession();
        return (Book) session.get(Book.class, id);
    }

    /**
     * Adds a book to the database
     * @param book
     */
    public void addBook(Book book) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Deletes a book from the database
     * @param book
     */
    public void deleteBook(Book book) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(book);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Updates a book in
     *  the database given a book object
     * @param book
     */
    public void updateBook(Book book) {
        Session s = HibernateUtility.getSessionFactory().openSession();
        s.merge(book);
        s.beginTransaction();
        s.getTransaction().commit();
        s.close();
    }
}
