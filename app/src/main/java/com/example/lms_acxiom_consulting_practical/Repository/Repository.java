package com.example.lms_acxiom_consulting_practical.Repository;

import android.content.Context;

import com.example.lms_acxiom_consulting_practical.DAO.BookDAO;
import com.example.lms_acxiom_consulting_practical.DAO.IssuedBooksDAO;
import com.example.lms_acxiom_consulting_practical.DAO.UserDAO;
import com.example.lms_acxiom_consulting_practical.DTO.Book;
import com.example.lms_acxiom_consulting_practical.DTO.IssuedBooks;
import com.example.lms_acxiom_consulting_practical.DTO.User;
import com.example.lms_acxiom_consulting_practical.DataBase.LMSDataBase;

import java.util.List;

public  class Repository {
    public LMSDataBase lmsDataBase;
    public BookDAO bookDAO;
    public UserDAO userDAO;

    public IssuedBooksDAO issuedBooksDAO;
    public Context RepositoryContext;



    public Repository(Context RepositoryContext){
        this.RepositoryContext=RepositoryContext;
        lmsDataBase=LMSDataBase.getDataBase(RepositoryContext);
        userDAO= lmsDataBase.ReturnUserDAO();
        bookDAO=lmsDataBase.ReturnBookDAO();
        issuedBooksDAO= lmsDataBase.ReturnIssuedBooksDAO();
    }

    /*
    Creating Method to perform operations.
     */

    public void  adduser(User user){
        userDAO.AddUser(user);
    }
    public  void AddBook(Book book){
        bookDAO.AddBook(book);
    }

    /*
    Method to Verify User.
     */
    public User LoginUser(String Email,String Password){
       return userDAO.ReturnUser(Email,Password);
    }

    public List<IssuedBooks> GetIssuedBooks(int UserId){
        return  issuedBooksDAO.ReturnIssuedBooks(UserId);
    }

    public IssuedBooks GetAllIssuedBooks(){
        return  issuedBooksDAO.ReturnBooks();
    }

    public void  InsertIssuedBooks(IssuedBooks issuedBooks){
        issuedBooksDAO.InsertInIssuedBook(issuedBooks);
    }

    public void DeleteIssuedBooks(int id){
        issuedBooksDAO.DeleteIssuedBook(id);
    }

    public void TAkeBAckBooks(int id){
        bookDAO.TakeBackBook(id);
    }

    public void IssueBooks(int id){
        bookDAO.IssueBook(id);
    }
    public List<Book> GetAllBook(){
        return bookDAO.GetAllBook();
    }

    public List<Book> ReturnBook(String Bookname){
        return  bookDAO.ReturnBook(Bookname);
    }
    public Boolean BookIssuedOrNot(int BookId){
        return  bookDAO.BookIssuedOrNot(BookId);
    }

}
