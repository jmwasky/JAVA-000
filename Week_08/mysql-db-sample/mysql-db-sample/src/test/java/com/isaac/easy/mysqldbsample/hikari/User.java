package com.isaac.easy.mysqldbsample.hikari;

/**
 * @author think
 * @date 2020/12/9
 */
public class User {
    private String userName;
    private String name;
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName( String userName ) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword( String userPassword ) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
