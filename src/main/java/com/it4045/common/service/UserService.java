package com.it4045.common.service;

import com.it4045.common.dao.UserDAO;
import com.it4045.common.dto.User;

import java.io.IOException;

public class UserService {
    UserDAO userDAO;

    public UserService() throws IOException {
        this.userDAO = new UserDAO();
    }

    public void createUser(User user) throws Exception {
        this.userDAO.addUser(user);
    }
}
