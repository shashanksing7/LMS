package com.example.lms_acxiom_consulting_practical.DTO;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Book {

    public Book(){

    }
    public Book(String bookName, String author, Boolean bookIssued) {
        BookName = bookName;
        Author = author;
        BookIssued = bookIssued;
    }

    @PrimaryKey(autoGenerate = true)
    private  int BookId;
    private  String BookName;
    private  String Author;
    private  Boolean BookIssued;

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Boolean getBookIssued() {
        return BookIssued;
    }

    public void setBookIssued(Boolean bookIssued) {
        BookIssued = bookIssued;
    }


}
