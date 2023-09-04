package com.example.lms_acxiom_consulting_practical.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.lms_acxiom_consulting_practical.DTO.Book;
import com.example.lms_acxiom_consulting_practical.DTO.User;

import java.util.List;

@Dao
public interface BookDAO {

    @Insert
    void AddBook(Book book);

    @Query("SELECT * FROM Book WHERE BookName LIKE '%' || :bookName || '%'")
    List<Book> ReturnBook(String bookName);

    @Query("UPDATE Book SET BookIssued = 0 WHERE BookId = :id") // Take back the book
    void TakeBackBook(int id);

    @Query("UPDATE Book SET BookIssued = 1 WHERE BookId = :id") // Issue the book
    void IssueBook(int id);

    @Query("SELECT * FROM Book WHERE BookIssued =0")
    List<Book> GetAllBook();

    @Query("SELECT BookIssued FROM Book WHERE BookId LIKE:BookId")
    Boolean BookIssuedOrNot(int BookId);
}

