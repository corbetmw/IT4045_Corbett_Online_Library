package com.it4045.common.exceptions;

public class UserException extends Exception
{
    private String userName;

    public UserException(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return this.userName;
    }
}
