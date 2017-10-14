package com.rodion.silvermilldata.domain;

import java.io.Serializable;

/**
 * @author Rodion
 */
public class User extends ValueObject {

    private static final long serialVersionUID = 1L;

    private String userId;
    private String userName;
    private String password;

    public User(String userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected Object[] getIdFields() {
        return new Object[]{userId, userName, password};
    }
}
