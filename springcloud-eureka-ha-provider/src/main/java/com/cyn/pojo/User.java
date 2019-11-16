package com.cyn.pojo;

/**
 * @author chenyn
 * @version 1.0
 * @date 2019/10/27 19:57
 */
public class User {
    private String userName;
    private int userAge;
    private String userSex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userSex='" + userSex + '\'' +
                '}';
    }

    public User(String userName, int userAge, String userSex) {
        this.userName = userName;
        this.userAge = userAge;
        this.userSex = userSex;
    }
}
