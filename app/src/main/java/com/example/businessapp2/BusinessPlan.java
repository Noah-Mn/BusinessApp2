package com.example.businessapp2;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class BusinessPlan extends AppCompatActivity {
    ImageView tasks, chatsandcalls, menu, projects, businessplan, invoice, salesandexpences;
    DownloadManager downloadManager;
    Button business_plan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_plan);
        menu = findViewById(R.id.menuicon);
        tasks = findViewById(R.id.tasks);
        chatsandcalls = findViewById(R.id.chatsandcalls);
        projects = findViewById(R.id.projects);
        businessplan = findViewById(R.id.businessplan);
        invoice = findViewById(R.id.invoice);
        salesandexpences = findViewById(R.id.salesandexpences);
        business_plan = findViewById(R.id.business_plan);


        business_plan.setOnClickListener(v -> {
            downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
            Uri uri = Uri.parse("https://www.bgateway.com/assets/templates/business-plan-template-2020.docx");
            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            Long reference = downloadManager.enqueue(request);
        });

        chatsandcalls.setOnClickListener(v -> startActivity(new Intent(BusinessPlan.this, Chats_and_Calls.class)));

        businessplan.setOnClickListener(v -> startActivity(new Intent(BusinessPlan.this, BusinessPlan.class)));

        invoice.setOnClickListener(v -> startActivity(new Intent(BusinessPlan.this, Invoice.class)));

        salesandexpences.setOnClickListener(v -> startActivity(new Intent(BusinessPlan.this, SalesAndExpences.class)));

        menu.setOnClickListener(v -> startActivity(new Intent(BusinessPlan.this, Menu.class)));

        tasks.setOnClickListener(v -> startActivity(new Intent(BusinessPlan.this, Tasks.class)));

        projects.setOnClickListener(v -> startActivity(new Intent(BusinessPlan.this, Projects.class)));
    }
    public void onBackPressed(){
        Intent intent = new Intent(BusinessPlan.this, HomePage.class);
        startActivity(intent);
        finish();
    }
}