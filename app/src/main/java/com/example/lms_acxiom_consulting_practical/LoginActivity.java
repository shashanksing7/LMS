package com.example.lms_acxiom_consulting_practical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lms_acxiom_consulting_practical.DTO.IssuedBooks;
import com.example.lms_acxiom_consulting_practical.DTO.User;
import com.example.lms_acxiom_consulting_practical.ViewModel.LMSViewModel;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    AppCompatButton LoginButton;
    EditText Email,Password;
    TextView Signup,AdminLogin;



    LMSViewModel lmsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton=findViewById(R.id.UserLoginButton);
        Email=findViewById(R.id.UserEmail);
        Password=findViewById(R.id.UserPassword);
        Signup=findViewById(R.id.UserSignup);
        AdminLogin=findViewById(R.id.AdminLoginClick);
        // Initialize the ViewModel
        lmsViewModel = new ViewModelProvider(this).get(LMSViewModel.class);


        /*
        OnClick Listener.
         */
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taketosignup();
            }
        });

        AdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taketoAdminLogin();
            }
        });

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUSer();
            }
        });
    }


    /*
    Method to take user to SignupScreen.
     */
    public  void taketosignup(){
        Intent intent=new Intent(LoginActivity.this,com.example.lms_acxiom_consulting_practical.Signup.class);
        startActivity(intent);
    }

    public  void taketoAdminLogin(){
        Intent intent=new Intent(LoginActivity.this,com.example.lms_acxiom_consulting_practical.AdminLogin.class);
        startActivity(intent);
    }


    /*
Method to login user.
 */

    public void LoginUSer(){
        String email=Email.getText().toString();
        String password=Password.getText().toString();

        User user =lmsViewModel.LoginUser(email,password);
        if(user==null){
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
        else {
            Bundle databundle = new Bundle();
            databundle.putString("Name", user.getUserName());
            databundle.putString("Email", user.getEmail());
            databundle.putInt("BookBorrowed", user.getBookBorrowed());
            databundle.putInt("UserId",user.getUserid());

            Intent intent = new Intent(LoginActivity.this, UserHome.class);
            intent.putExtra("UserData", databundle); // Use "UserData" as the key for the Bundle
            startActivity(intent);
        }


    }
}

