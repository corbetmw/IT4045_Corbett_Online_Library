package com.it4045.common.dao;

import com.it4045.common.dto.UserBook;

import java.util.List;

public interface IUserBookDAO {

    public List<UserBook> getAllUserBooks() throws Exception;
    public void addUserBook(UserBook userBook) throws Exception;
    public void deleteUserBook(UserBook userBook) throws Exception;
    public void updateUserBook(UserBook userBook) throws Exception;
}
