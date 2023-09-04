package com.example.lms_acxiom_consulting_practical.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.lms_acxiom_consulting_practical.DTO.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void AddUser(User user);

    @Query("SELECT * FROM User u WHERE u.Email LIKE:Email AND u.Password LIKE:Password")
    User ReturnUser(String Email,String Password);

    @Query("SELECT BookBorrowed FROM User WHERE userid LIKE:UserId")
    int BooksBorrowed(int UserId);
    @Query("UPDATE user SET BookBorrowed=:nOfBooksBORROWED WHERE userid LIKE:UserId")
    void UpdateBookBorrowed(int UserId,int nOfBooksBORROWED);

    @Query("SELECT * FROM User")
    List<User> ReturnAllUser();

    @Query("SELECT * FROM User WHERE UserName LIKE '%' || :username||'%'")
    List<User> ReturnSearchUser(String username);
}
