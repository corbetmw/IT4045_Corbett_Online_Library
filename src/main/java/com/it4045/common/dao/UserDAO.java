package com.it4045.common.dao;

import com.it4045.common.dto.User;
import com.it4045.common.exceptions.UserNotFoundException;
import com.it4045.common.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

/**
 * This class uses the User object to interact with
 * the mySQL database using hibernate
 */
public class UserDAO implements IUserDAO {

    public UserDAO() throws IOException {

    }

    /**
     * This method will fetch all of our users from the database
     *
     * @return List<User> a list of all our users
     */
    public List<User> getAllUsers() throws Exception {
        Session session = HibernateUtility.getSessionFactory().openSession();
        List<User> list = session.createCriteria(User.class).list();
        session.close();
        return list;
    }

    /**
     * This method queries the database based on a given userName and then
     * populates the a user object if one is found
     *
     * @param userName
     * @return User
     * @throws Exception
     */
    public User getUserByUsername(String userName) throws Exception {
        Session session = HibernateUtility.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from User where userName=:userName");
            query.setParameter("userName", userName);

            User user = (User) query.uniqueResult();
            return user;
        } catch (Exception e) {
            throw new UserNotFoundException("The user you're looking for doesn't exist");
        }
    }

    /**
     * This method searches the database for a user given userId and then populates
     * a user object if one is found
     *
     * @param id
     * @return User
     * @throws Exception
     */
    public User getUserById(int id) throws Exception {
        Session session = HibernateUtility.getSessionFactory().openSession();
        return (User) session.get(User.class, id);
    }

    /**
     * This method creates a user in the database. I
     * would like it to return the generated id at some point.
     *
     * @param user
     * @throws Exception
     */
    public void addUser(User user) throws Exception {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * This method updated a user in the database given an
     * entire User object.
     *
     * @param user
     * @throws Exception
     */
    public void updateUser(User user) throws Exception {
        Session s = HibernateUtility.getSessionFactory().openSession();
        s.merge(user);
        s.beginTransaction();
        s.getTransaction().commit();
        s.close();
    }

    /**
     * This method removes a user in the database given
     * an entire User object.
     *
     * @param user
     * @throws Exception
     */
    public void deleteUser(User user) throws Exception {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
}
