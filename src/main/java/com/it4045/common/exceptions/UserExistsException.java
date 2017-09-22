package com.it4045.common.exceptions;

public class UserExistsException extends Exception
{
    private String userName;

    public UserExistsException(String userName)
    {
        this.userName = userName;
    }

    public String getUsername()
    {
        return this.userName;
    }
}
