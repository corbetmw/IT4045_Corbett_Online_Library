package com.it4045.common.service;

import com.it4045.common.dao.UserDAO;
import com.it4045.common.dto.User;
import com.it4045.common.exceptions.InvalidLoginException;
import com.it4045.common.exceptions.UserNotFoundException;

import java.io.IOException;

public class LoginService {

    public User login(String username, String password) throws InvalidLoginException, IOException {

        UserDAO userDAO = new UserDAO();

        try {
            User user = userDAO.getUserByUsername(username);
            if(user.getPassword().equals(password)){
                return user;
            }else{
                throw new InvalidLoginException("The username and password combination doesn't exist");
            }
        } catch (UserNotFoundException e) {
            throw new InvalidLoginException("The username and password combination doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new InvalidLoginException("Invalid login");
    }

}
