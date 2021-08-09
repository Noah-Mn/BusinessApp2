package com.example.businessapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Chats_and_Calls extends AppCompatActivity {
    ImageView tasks, chatsandcalls, menu, projects, businessplan, invoice, salesandexpences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats_and_calls);
        menu = findViewById(R.id.menuicon);
        tasks = findViewById(R.id.tasks);
        chatsandcalls = findViewById(R.id.chatsandcalls);
        projects = findViewById(R.id.projects);
        businessplan = findViewById(R.id.businessplan);
        invoice = findViewById(R.id.invoice);
        salesandexpences = findViewById(R.id.salesandexpences);

        chatsandcalls.setOnClickListener(v -> startActivity(new Intent(Chats_and_Calls.this, Chats_and_Calls.class)));

        businessplan.setOnClickListener(v -> startActivity(new Intent(Chats_and_Calls.this, BusinessPlan.class)));

        invoice.setOnClickListener(v -> startActivity(new Intent(Chats_and_Calls.this, Invoice.class)));

        salesandexpences.setOnClickListener(v -> startActivity(new Intent(Chats_and_Calls.this, SalesAndExpences.class)));

        menu.setOnClickListener(v -> startActivity(new Intent(Chats_and_Calls.this, Menu.class)));

        tasks.setOnClickListener(v -> startActivity(new Intent(Chats_and_Calls.this, Tasks.class)));

        projects.setOnClickListener(v -> startActivity(new Intent(Chats_and_Calls.this, Projects.class)));
    }
    public void onBackPressed(){
        Intent intent = new Intent(Chats_and_Calls.this, HomePage.class);
        startActivity(intent);
        finish();
    }
}