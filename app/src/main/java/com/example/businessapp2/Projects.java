package com.example.businessapp2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Projects extends AppCompatActivity {
    ImageView tasks, chatsandcalls, menu, projects, businessplan, invoice, salesandexpences;
    Button addproject;
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    DatabaseHelper2 databaseHelper2;
    ArrayList<String> name, deadline, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        menu = findViewById(R.id.menuicon);
        tasks = findViewById(R.id.tasks);
        chatsandcalls = findViewById(R.id.chatsandcalls);
        projects = findViewById(R.id.projects);
        businessplan = findViewById(R.id.businessplan);
        invoice = findViewById(R.id.invoice);
        salesandexpences = findViewById(R.id.salesandexpences);
        addproject = findViewById(R.id.addproject);
        recyclerView = findViewById(R.id.recyclerView);

        databaseHelper2 = new DatabaseHelper2(this);
        name = new ArrayList<>();
        deadline = new ArrayList<>();
        description = new ArrayList<>();

        storeProjects();

        customAdapter = new CustomAdapter(this, name, deadline, description);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        chatsandcalls.setOnClickListener(v -> startActivity(new Intent(Projects.this, Chats_and_Calls.class)));

        businessplan.setOnClickListener(v -> startActivity(new Intent(Projects.this, BusinessPlan.class)));

        invoice.setOnClickListener(v -> startActivity(new Intent(Projects.this, Invoice.class)));

        salesandexpences.setOnClickListener(v -> startActivity(new Intent(Projects.this, SalesAndExpences.class)));

        menu.setOnClickListener(v -> startActivity(new Intent(Projects.this, Menu.class)));

        tasks.setOnClickListener(v -> startActivity(new Intent(Projects.this, Tasks.class)));

        projects.setOnClickListener(v -> startActivity(new Intent(Projects.this, Projects.class)));

        addproject.setOnClickListener(v -> startActivity(new Intent(Projects.this, NewProject.class)));
    }
    public void onBackPressed(){
        Intent intent = new Intent(Projects.this, HomePage.class);
        startActivity(intent);
        finish();
    }
    void storeProjects(){
        Cursor cursor = databaseHelper2.getdata();
        if (cursor.getCount() == 0 ){
            Toast.makeText(this, "No data to display", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                name.add(cursor.getString(0));
                deadline.add(cursor.getString(3));
                description.add(cursor.getString(6));
            }
        }
    }
}