package com.example.lms_acxiom_consulting_practical.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.lms_acxiom_consulting_practical.DTO.Book;
import com.example.lms_acxiom_consulting_practical.DTO.IssuedBooks;
import com.example.lms_acxiom_consulting_practical.DTO.User;
import com.example.lms_acxiom_consulting_practical.DataBase.LMSDataBase;
import com.example.lms_acxiom_consulting_practical.Repository.Repository;

import java.util.List;

public class LMSViewModel extends AndroidViewModel {

    private Repository repository;
    public LMSViewModel(@NonNull Application application) {
        super(application);
        repository=new Repository(application);
    }
        /*
    Creating Method to perform operations.
     */

    public void  adduser(User user){
        repository.adduser(user);

    }
    public  void AddBook(Book book){
        repository.AddBook(book);
    }

    /*
    Method to Verify User.
     */
    public User LoginUser(String Email,String Password){
        return repository.LoginUser(Email,Password);
    }

    public List<IssuedBooks> GetIssuedBooks(int UserId){
        return repository.GetIssuedBooks(UserId);
    }

    public IssuedBooks GetAllIssuedBooks(){
        return  repository.GetAllIssuedBooks();
    }

    public void  InsertIssuedBooks(IssuedBooks issuedBooks){
        repository.InsertIssuedBooks(issuedBooks);
    }
    public void DeleteIssuedBooks(int id){
        repository.DeleteIssuedBooks(id);
    }
    public void TAkeBAckBooks(int id){
        repository.TAkeBAckBooks(id);
    }

    public void IssueBooks(int id){
        repository.IssueBooks(id);
    }
    public List<Book> GetAllBook(){
        return repository.GetAllBook();
    }

    public List<Book> ReturnBook(String Bookname){
        return  repository.ReturnBook(Bookname);
    }

    public Boolean BookIssuedOrNot(int BookId){
        return  repository.BookIssuedOrNot(BookId);
    }


}
