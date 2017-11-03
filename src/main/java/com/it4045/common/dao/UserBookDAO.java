package com.it4045.common.dao;

import com.it4045.common.dto.UserBook;
import com.it4045.common.utility.HibernateUtility;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;

public class UserBookDAO implements IUserBookDAO {

    public UserBookDAO() throws IOException {

    }

    /**
     * Get all userBooks from the mySQL database
     * in the form of a list of UserBook objects
     * @return <UserBook></>
     */
    public List<UserBook> getAllUserBooks() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<UserBook> userBookList = session.createCriteria(UserBook.class).list();
        session.close();
        return userBookList;
    }

    public UserBook getUserBookById(int id){
        Session session = HibernateUtility.getSessionFactory().openSession();
        return (UserBook) session.get(UserBook.class, id);
    }

    /**
     * Adds a userBook to the database
     * @param userBook
     */
    public void addUserBook(UserBook userBook) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(userBook);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Deletes a userBook from the database
     * @param userBook
     */
    public void deleteUserBook(UserBook userBook) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(userBook);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Updates a userBook in
     *  the database given a userBook object
     * @param userBook
     */
    public void updateUserBook(UserBook userBook) {
        Session s = HibernateUtility.getSessionFactory().openSession();
        s.merge(userBook);
        s.beginTransaction();
        s.getTransaction().commit();
        s.close();
    }
}
