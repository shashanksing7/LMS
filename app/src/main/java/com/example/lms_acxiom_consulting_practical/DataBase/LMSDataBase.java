package com.example.lms_acxiom_consulting_practical.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lms_acxiom_consulting_practical.DAO.BookDAO;
import com.example.lms_acxiom_consulting_practical.DAO.IssuedBooksDAO;
import com.example.lms_acxiom_consulting_practical.DAO.UserDAO;
import com.example.lms_acxiom_consulting_practical.DTO.Book;
import com.example.lms_acxiom_consulting_practical.DTO.IssuedBooks;
import com.example.lms_acxiom_consulting_practical.DTO.User;

@Database(entities = {User.class, Book.class, IssuedBooks.class},version = 1,exportSchema = true)
public abstract class LMSDataBase extends RoomDatabase {

    /*
    Creating a instance of the Database.
     */
    private static LMSDataBase roomDatabase;
    /*
    Creating a Private String Variable for the name of the database.
     */
    private static  final String DataBaseNAme="RoomDataBase";
    /*
    creating method to access the singleton object of the database.
     */
    public static  synchronized LMSDataBase getDataBase(Context context){
        if(roomDatabase==null){
            roomDatabase= Room.databaseBuilder(context, LMSDataBase.class,DataBaseNAme)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return roomDatabase;
    }

    /*
    Creating Methods to Return DAO.
     */
    public abstract UserDAO ReturnUserDAO();

    public  abstract BookDAO ReturnBookDAO();

    public abstract IssuedBooksDAO ReturnIssuedBooksDAO();
}
