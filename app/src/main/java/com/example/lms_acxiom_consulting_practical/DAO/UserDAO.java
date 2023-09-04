package com.example.lms_acxiom_consulting_practical.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.lms_acxiom_consulting_practical.DTO.User;

@Dao
public interface UserDAO {
    @Insert
    void AddUser(User user);

    @Query("SELECT * FROM User u WHERE u.Email LIKE:Email AND u.Password LIKE:Password")
    User ReturnUser(String Email,String Password);
}
