package com.example.lms_acxiom_consulting_practical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    EditText AdminEmail, AdminPassword;
    AppCompatButton AdminLogin;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        AdminEmail=findViewById(R.id.AdminEmail);
        AdminPassword=findViewById(R.id.AdminPassword);
        AdminLogin=findViewById(R.id.AdminLoginButton);


        // Initialize SharedPreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();

        AdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckAdminLogin();
            }
        });
    }

    /*
    Login User
     */
    public void CheckAdminLogin() {
        String enteredUsername = AdminEmail.getText().toString(); // Replace with the actual username entered by the user
        String enteredPassword = AdminPassword.getText().toString(); // Replace with the actual password entered by the user

        // Check if the entered username and password are correct
        if (enteredUsername.equals("admin") && enteredPassword.equals("admin")) {
            // Save a boolean flag indicating that the user is logged in
            editor.putBoolean("isLoggedIn", true);
            editor.apply();

            // Start the main activity or any other activity
            Intent intent = new Intent(AdminLogin.this, AdminHomeScreen.class);
            startActivity(intent);
            finish(); // Close the login activity
        } else {
            // Display an error message to the user indicating incorrect credentials
            Toast.makeText(AdminLogin.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
        }
    }


}

