package com.it4045.common.valueObjects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserVO implements Persistence
{
    public UserVO()
    {
    }

    public UserVO(String userName)
    {
        this.userName = userName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int id;
    private String userName;
    private String password;
    private String fullName;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return userName;
    }

    public void setUsername(String userName)
    {
        this.userName = userName;
    }

    public String getFirstName()
    {
        return fullName;
    }

    public void setFirstName(String fullName)
    {
        this.fullName = fullName;
    }


    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public int hashCode()
    {
        int result = 17;
        result = result * userName.hashCode();
        result = result * password.hashCode();
        result = result * fullName.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object that)
    {
        if (!(that instanceof UserVO))
        {
            return false;
        }

        if (this == that)
        {
            return true;
        }

        UserVO userVO = (UserVO) that;
        return this.userName.equals(userVO.getUsername());
    }
}
