package com.example.businessapp2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SalesAndExpences extends AppCompatActivity {
    ImageView tasks, chatsandcalls, menu, projects, businessplan, invoice, salesandexpences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_and_expences);
        menu = findViewById(R.id.menuicon);
        tasks = findViewById(R.id.tasks);
        chatsandcalls = findViewById(R.id.chatsandcalls);
        projects = findViewById(R.id.projects);
        businessplan = findViewById(R.id.businessplan);
        invoice = findViewById(R.id.invoice);
        salesandexpences = findViewById(R.id.salesandexpences);

        chatsandcalls.setOnClickListener(v -> startActivity(new Intent(SalesAndExpences.this, Chats_and_Calls.class)));

        businessplan.setOnClickListener(v -> startActivity(new Intent(SalesAndExpences.this, BusinessPlan.class)));

        invoice.setOnClickListener(v -> startActivity(new Intent(SalesAndExpences.this, Invoice.class)));

        salesandexpences.setOnClickListener(v -> startActivity(new Intent(SalesAndExpences.this, SalesAndExpences.class)));

        menu.setOnClickListener(v -> startActivity(new Intent(SalesAndExpences.this, Menu.class)));

        tasks.setOnClickListener(v -> startActivity(new Intent(SalesAndExpences.this, Tasks.class)));

        projects.setOnClickListener(v -> startActivity(new Intent(SalesAndExpences.this, Projects.class)));
    }
    public void onBackPressed(){
        Intent intent = new Intent(SalesAndExpences.this, HomePage.class);
        startActivity(intent);
        finish();
    }
}