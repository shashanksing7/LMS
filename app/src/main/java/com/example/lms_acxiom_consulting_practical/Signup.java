package com.example.lms_acxiom_consulting_practical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.lms_acxiom_consulting_practical.DTO.User;
import com.example.lms_acxiom_consulting_practical.ViewModel.LMSViewModel;

public class Signup extends AppCompatActivity {

    EditText UserName,UserEmail,UserPassword;
    LMSViewModel lmsViewModel;
    AppCompatButton SignupButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        UserName=findViewById(R.id.UserSignUpName);
        UserEmail=findViewById(R.id.UserSignUpEmail);
        UserPassword=findViewById(R.id.UserSignUpPassword);
        lmsViewModel = new ViewModelProvider(this).get(LMSViewModel.class);
        SignupButton=findViewById(R.id.SignupButton);
        SignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Adduser();
            }
        });



    }

    /*
    Method to SIgnup User.
     */
    public void Adduser(){
        String Email=UserEmail.getText().toString();
        String Name=UserName.getText().toString();
        String Password=UserPassword.getText().toString();
        User user=new User(Name,Email,Password,0);
        lmsViewModel.adduser(user);
        Intent intent=new Intent(Signup.this, LoginActivity.class);
        startActivity(intent);

    }
}