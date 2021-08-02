package com.example.businessapp2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    EditText email, username, password,passwordagain;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        databaseHelper = new DatabaseHelper(this);
        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.Password);
        passwordagain = findViewById(R.id.PasswordAgain);
        username = findViewById(R.id.username);
        signup = findViewById(R.id.signup);

        signup.setOnClickListener(v -> {
            String emailaddress = email.getText().toString();
            String usersname = username.getText().toString();
            String passwd = password.getText().toString();
            String passwdagain = passwordagain.getText().toString();
            if (emailaddress.isEmpty()||usersname.isEmpty()||passwd.isEmpty()||passwdagain.isEmpty()){
                Toast.makeText(getApplicationContext(),"Please fill all the spaces", Toast.LENGTH_SHORT).show();
            }else {
                if (passwd.equals(passwdagain)){
                    boolean checkemail2 = databaseHelper.checkemail(emailaddress);
                        if (checkemail2){
                            boolean insert = databaseHelper.insert(emailaddress,usersname,passwd);
                            if (insert) {
                                Toast.makeText(getApplicationContext(), "SignUp successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Signup.this, LoginActivity.class));
                            }
                        }else
                            Toast.makeText(getApplicationContext(),"Email already exists",Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(getApplicationContext(),"Passwords don't match", Toast.LENGTH_SHORT).show();
            }
        });
    }

}



