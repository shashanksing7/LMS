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
import android.widget.EditText;
import android.widget.Toast;

import com.example.lms_acxiom_consulting_practical.DTO.Book;
import com.example.lms_acxiom_consulting_practical.ViewModel.LMSViewModel;

public class AdminHomeScreen extends AppCompatActivity {

    EditText BookName,AuthorName;
    AppCompatButton AddButton;

    LMSViewModel lmsViewModel;


    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_screen);
        BookName=findViewById(R.id.UserSignUpName);
        AuthorName=findViewById(R.id.UserSignUpEmail);
        AddButton=findViewById(R.id.SignupButton);
        lmsViewModel=new ViewModelProvider(this).get(LMSViewModel.class);
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user();
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

}