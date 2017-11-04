package com.it4045.common.test;

import com.it4045.common.dao.UserDAO;
import com.it4045.common.dto.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains unit tests for the UserDAO class.
 * It tests pretty much all of its methods. It
 * uses user jdoe for all of the tests.
 */
public class UserDAOTest {

    UserDAO userDAO;
    @Before
    public void setUp() throws Exception {
        userDAO= new UserDAO();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAllUsers() throws Exception {
        assert(userDAO.getAllUsers().size() == 1);
    }

    @Test
    public void testGetUserByUsername() throws Exception {
        assert(userDAO.getUserByUsername("jdoe").getId() == 1);
    }

    @Test
    public void testGetUserById() throws Exception {
        assert(userDAO.getUserById(1).getUserName().equalsIgnoreCase("jdoe"));
    }

    @Test
    public void testAddUser() throws Exception {

        User user = new User();
        user.setFullName("Jane Doe");
        user.setPassword("password");
        user.setUserName("jadoe");
        user.setRole("");

        userDAO.addUser(user);
    }

    @Test
    public void testUpdateUser() throws Exception {
//        User john = userDAO.getUserByUsername("jdoe");
//        john.setPassword("testupdateuser");
//        userDAO.updateUser(john);
    }

    @Test
    public void testDeleteUser() throws Exception {
//        User user = userDAO.getUserByUsername("jdoe");
//        userDAO.deleteUser(user);
    }
}
