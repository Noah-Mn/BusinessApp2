package com.example.businessapp2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    ImageView tasks, chatsandcalls, menuicon, projects, businessplan, invoice, salesandexpences;
    TextView menu, tasktext, chatscall, plan, salesexpences, invoicetext, projecttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menuicon = findViewById(R.id.menuicon);
        menu = findViewById(R.id.menu);
        tasktext = findViewById(R.id.tasktext);
        chatscall = findViewById(R.id.chatscalls);
        plan = findViewById(R.id.plan);
        salesexpences = findViewById(R.id.salesexpences);
        invoicetext = findViewById(R.id.invoicetext);
        projecttext = findViewById(R.id.projecttext);
        tasks = findViewById(R.id.tasks);
        chatsandcalls = findViewById(R.id.chatsandcalls);
        projects = findViewById(R.id.projects);
        businessplan = findViewById(R.id.businessplan);
        invoice = findViewById(R.id.invoice);
        salesandexpences = findViewById(R.id.salesandexpences);

        menuicon.setOnClickListener(v -> startActivity(new Intent(Menu.this, HomePage.class)));

        menu.setOnClickListener(v -> startActivity(new Intent(Menu.this, HomePage.class)));

        chatsandcalls.setOnClickListener(v -> startActivity(new Intent(Menu.this, Chats_and_Calls.class)));

        chatscall.setOnClickListener(v -> startActivity(new Intent(Menu.this, Chats_and_Calls.class)));

        businessplan.setOnClickListener(v -> startActivity(new Intent(Menu.this, BusinessPlan.class)));

        plan.setOnClickListener(v -> startActivity(new Intent(Menu.this, BusinessPlan.class)));

        invoice.setOnClickListener(v -> startActivity(new Intent(Menu.this, Invoice.class)));

        invoicetext.setOnClickListener(v -> startActivity(new Intent(Menu.this, Invoice.class)));

        salesandexpences.setOnClickListener(v -> startActivity(new Intent(Menu.this, SalesAndExpences.class)));

        salesexpences.setOnClickListener(v -> startActivity(new Intent(Menu.this, SalesAndExpences.class)));

        tasks.setOnClickListener(v -> startActivity(new Intent(Menu.this, Tasks.class)));

        tasktext.setOnClickListener(v -> startActivity(new Intent(Menu.this, Tasks.class)));

        projects.setOnClickListener(v -> startActivity(new Intent(Menu.this, Projects.class)));

        projecttext.setOnClickListener(v -> startActivity(new Intent(Menu.this, Projects.class)));

    }
}