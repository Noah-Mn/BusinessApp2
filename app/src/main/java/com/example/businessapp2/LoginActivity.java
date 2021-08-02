package com.example.businessapp2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    TextView gotosignup;
    DatabaseHelper databaseHelper;
    TextView email,password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databaseHelper = new DatabaseHelper(this);
        email = findViewById(R.id.EmailAddress);
        password = findViewById(R.id.Password);
        gotosignup = findViewById(R.id.gotosignup);
        login = findViewById(R.id.login);

        gotosignup.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, Signup.class)));

        login.setOnClickListener(v -> {
            String emailaddress = email.getText().toString();
            String passwd = password.getText().toString();
            boolean checkemailpassword = databaseHelper.checkemailpassword(emailaddress,passwd);
            if (checkemailpassword){
                startActivity(new Intent(LoginActivity.this, HomePage.class));
            }else
                Toast.makeText(getApplicationContext(),"Please enter the correct email or password",Toast.LENGTH_SHORT).show();

        });
    }


}