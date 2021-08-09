package com.example.businessapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.CursorJoiner;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HomePage extends AppCompatActivity {
    ImageView tasks, chatsandcalls, menu, projects, businessplan, invoice, salesandexpences;
    TextView username;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        menu = findViewById(R.id.menuicon);
        tasks = findViewById(R.id.tasks);
        chatsandcalls = findViewById(R.id.chatsandcalls);
        projects = findViewById(R.id.projects);
        businessplan = findViewById(R.id.businessplan);
        invoice = findViewById(R.id.invoice);
        salesandexpences = findViewById(R.id.salesandexpences);
        username = findViewById(R.id.username);


        chatsandcalls.setOnClickListener(v -> startActivity(new Intent(HomePage.this, Chats_and_Calls.class)));

        businessplan.setOnClickListener(v -> startActivity(new Intent(HomePage.this, BusinessPlan.class)));

        invoice.setOnClickListener(v -> startActivity(new Intent(HomePage.this, Invoice.class)));

        salesandexpences.setOnClickListener(v -> startActivity(new Intent(HomePage.this, SalesAndExpences.class)));

        menu.setOnClickListener(v -> startActivity(new Intent(HomePage.this, Menu.class)));

        tasks.setOnClickListener(v -> startActivity(new Intent(HomePage.this, Tasks.class)));

        projects.setOnClickListener(v -> startActivity(new Intent(HomePage.this, Projects.class)));

    }


}