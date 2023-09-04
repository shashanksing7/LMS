package com.example.lms_acxiom_consulting_practical.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.lms_acxiom_consulting_practical.DTO.IssuedBooks;

import java.util.List;

@Dao
public interface IssuedBooksDAO {
    @Insert
    void InsertInIssuedBook(IssuedBooks issuedBooks);

    @Query("SELECT * FROM IssuedBooks IB WHERE IB.UserId LIKE :UserId")
    List<IssuedBooks> ReturnIssuedBooks(int UserId);

    @Query("SELECT * FROM IssuedBooks")
    IssuedBooks ReturnBooks();

    @Query("DELETE FROM IssuedBooks  WHERE  id LIKE:id")
    void DeleteIssuedBook(int id);



}
