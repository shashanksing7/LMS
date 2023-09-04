package com.example.lms_acxiom_consulting_practical.DTO;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class IssuedBooks {
    @PrimaryKey(autoGenerate = true)
    int id;
    private String BookName;
    private String AuthorName;

    private int BookId;

    private int UserId;

    public IssuedBooks() {
    }

    public IssuedBooks( String bookName, String authorName, int bookId, int userId) {
        BookName = bookName;
        AuthorName = authorName;
        BookId = bookId;
        UserId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }
}
