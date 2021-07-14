package com.example.businessapp2;

import androidx.appcompat.app.AppCompatActivity;
import com.example.businessapp2.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button login;
  TextView gotosignup;
    EditText email, password;
    myDbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.EmailAddress);
        password = findViewById(R.id.Password);

        gotosignup = findViewById(R.id.gotosignup);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, HomePage.class));
            }
        });

        gotosignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(LoginActivity.this, Signup.class));
            }
        });

    }
    public void login(View v){
        String t1 = email.getText().toString();
        String t2 = password.getText().toString();

        if(t1.isEmpty() || t2.isEmpty()){
            Message.message(getApplicationContext(), "Please enter Both Email and Password");
        }
        else{
            long id = helper.insertData(t1,t2);
            if (id <= 0){
                Message.message(getApplicationContext(), "Insertion unsuccessful");
                email.setText(" ");
                password.setText(" ");
            }else {
                Message.message(getApplicationContext(), "Insertion successful");
                email.setText(" ");
                password.setText(" ");
            }
        }
    }
}