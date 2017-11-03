package com.it4045.common.dto;

/**
 * A class to represent the relationship between
 * a user and the books they check out
 */
public class UserBook {
    Integer id;
    Integer userId;
    Integer bookId;
    Boolean active;

    public UserBook() {
    }


    public UserBook(Integer id, Integer userId, Integer bookId, Boolean active) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
