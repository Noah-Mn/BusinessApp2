package com.example.businessapp2;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Invoice extends AppCompatActivity {
    ImageView tasks, chatsandcalls, menu, projects, businessplan, invoice, salesandexpences;
    Button create_invoice;
    DownloadManager downloadManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);
        menu = findViewById(R.id.menuicon);
        tasks = findViewById(R.id.tasks);
        chatsandcalls = findViewById(R.id.chatsandcalls);
        projects = findViewById(R.id.projects);
        businessplan = findViewById(R.id.businessplan);
        invoice = findViewById(R.id.invoice);
        salesandexpences = findViewById(R.id.salesandexpences);
        create_invoice = findViewById(R.id.create_invoice);

        create_invoice.setOnClickListener(v -> {
          downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
            Uri uri = Uri.parse("https://www.invoicesimple.com/wp-content/uploads/2018/06/Invoice-template-doc-top.docx");
            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            Long reference = downloadManager.enqueue(request);
        });
        chatsandcalls.setOnClickListener(v -> startActivity(new Intent(Invoice.this, Chats_and_Calls.class)));

        businessplan.setOnClickListener(v -> startActivity(new Intent(Invoice.this, BusinessPlan.class)));

        invoice.setOnClickListener(v -> startActivity(new Intent(Invoice.this, Invoice.class)));

        salesandexpences.setOnClickListener(v -> startActivity(new Intent(Invoice.this, SalesAndExpences.class)));

        menu.setOnClickListener(v -> startActivity(new Intent(Invoice.this, Menu.class)));

        tasks.setOnClickListener(v -> startActivity(new Intent(Invoice.this, Tasks.class)));

        projects.setOnClickListener(v -> startActivity(new Intent(Invoice.this, Projects.class)));
    }
    public void onBackPressed(){
        Intent intent = new Intent(Invoice.this, HomePage.class);
        startActivity(intent);
        finish();
    }
}