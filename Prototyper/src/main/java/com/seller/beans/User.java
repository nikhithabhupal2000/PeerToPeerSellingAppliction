package com.seller.beans;

public class User {



    private String userName;
    private String pwd;
    private String phoneNumber;

    public User(String userName, String pwd, String phoneNumber) {
        this.userName = userName;
        this.pwd = pwd;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }



    public String getUserName() {
        return userName;
    }

    public String getPwd() {
        return pwd;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
