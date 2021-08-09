package com.example.businessapp2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class Tasks extends AppCompatActivity {
    ImageView tasks, chatsandcalls, menu, projects, businessplan, invoice, salesandexpences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        menu = findViewById(R.id.menuicon);
        tasks = findViewById(R.id.tasks);
        chatsandcalls = findViewById(R.id.chatsandcalls);
        projects = findViewById(R.id.projects);
        businessplan = findViewById(R.id.businessplan);
        invoice = findViewById(R.id.invoice);
        salesandexpences = findViewById(R.id.salesandexpences);

        businessplan.setOnClickListener(v -> startActivity(new Intent(Tasks.this, BusinessPlan.class)));

        chatsandcalls.setOnClickListener(v -> startActivity(new Intent(Tasks.this, Chats_and_Calls.class)));

        invoice.setOnClickListener(v -> startActivity(new Intent(Tasks.this, Invoice.class)));

        salesandexpences.setOnClickListener(v -> startActivity(new Intent(Tasks.this, SalesAndExpences.class)));

        menu.setOnClickListener(v -> startActivity(new Intent(Tasks.this, Menu.class)));

        tasks.setOnClickListener(v -> startActivity(new Intent(Tasks.this, Tasks.class)));

        projects.setOnClickListener(v -> startActivity(new Intent(Tasks.this, Projects.class)));
    }
}