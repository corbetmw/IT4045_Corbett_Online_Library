package com.it4045.common.service;

import com.it4045.common.dao.UserBookDAO;
import com.it4045.common.dto.UserBook;

import java.io.IOException;

public class UserBookService {

    UserBookDAO userBookDAO;

    public UserBookService() throws IOException {
        this.userBookDAO = new UserBookDAO();
    }

    /**
     * Implements the UserBookDAO addUserBook method
     * @param userBook
     * @throws Exception
     */
    public void createUserBook(UserBook userBook) throws Exception {
        this.userBookDAO.addUserBook(userBook);
    }
    
}
