package com.azhen.domain;

/**
 * Created by azhen on 17-1-16.
 */
public class TUser {
    private Integer credits;
    private String userName;
    private String password;

    public TUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
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

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
