package com.it4045.common.dao;

import com.it4045.common.dto.User;

import java.util.List;

public interface IUserDAO {
    /**
     * Get all objects for specified type
     * @return all objects
     */
    public List<User> getAllUsers() throws Exception;

    public void addUser(User user) throws Exception;

    public void updateUser(User user) throws Exception;

    public void deleteUser(User user) throws Exception;

}
