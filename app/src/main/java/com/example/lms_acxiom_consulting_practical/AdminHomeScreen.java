package com.example.lms_acxiom_consulting_practical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lms_acxiom_consulting_practical.DTO.Book;
import com.example.lms_acxiom_consulting_practical.ViewModel.LMSViewModel;

public class AdminHomeScreen extends AppCompatActivity {

    EditText BookName,AuthorName;
   Button AddButton ,SearchUser,SearchBook;

    LMSViewModel lmsViewModel;

    TextView TotalAvailableBooks,TotalBooksIssued;

    int IssuedBook,AvailableBook;




    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @SuppressLint({"MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_screen);

        BookName=findViewById(R.id.UserSignUpName);
        AuthorName=findViewById(R.id.UserSignUpEmail);
        AddButton=findViewById(R.id.SignupButton);
        SearchBook=findViewById(R.id.searchBooksButton);
        SearchUser=findViewById(R.id.searchUserButton);

        TotalAvailableBooks=findViewById(R.id.totalavilable);
        TotalBooksIssued=findViewById(R.id.totalBooksIssued);

        lmsViewModel=new ViewModelProvider(this).get(LMSViewModel.class);

        AvailableBook=lmsViewModel.CountAllBook();
        IssuedBook=lmsViewModel.CountAllIssuedBook();

        if(AvailableBook!=0&&IssuedBook!=0){
            TotalAvailableBooks.setText("Total Books Issued"+": "+String.valueOf(AvailableBook));
            TotalBooksIssued.setText("Total Available Books"+": "+String.valueOf(IssuedBook));
        }
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user();
            }
        });
        SearchBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminHomeScreen.this, AdminSearchBook.class);
                startActivity(intent);
            }
        });
        SearchUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(AdminHomeScreen.this, AdminUserSearch.class);
                startActivity(intent);

            }
        });

    }

    public void user(){
        String bookname=BookName.getText().toString();
        String author=AuthorName.getText().toString();

        Book book=new Book(bookname,author,false);

        lmsViewModel.AddBook(book);
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        AvailableBook=lmsViewModel.CountAllBook();
        IssuedBook=lmsViewModel.CountAllIssuedBook();
        if(AvailableBook!=0&&IssuedBook!=0){
            TotalAvailableBooks.setText("Total Books Issued"+": "+String.valueOf(IssuedBook));
            TotalBooksIssued.setText("Total Available Books"+": "+String.valueOf(AvailableBook));
        }
    }
}