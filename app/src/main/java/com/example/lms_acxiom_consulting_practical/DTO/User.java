package com.example.lms_acxiom_consulting_practical.DTO;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    int userid;

    public User() {
        // Empty constructor
    }

    public User(String userName, String email, String password, int bookBorrowed) {

        UserName = userName;
        Email = email;
        Password = password;
        BookBorrowed = bookBorrowed;
    }

    private String UserName;
    private String Email;
    private  String Password;
    int BookBorrowed;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getBookBorrowed() {
        return BookBorrowed;
    }

    public void setBookBorrowed(int bookBorrowed) {
        BookBorrowed = bookBorrowed;
    }
}
