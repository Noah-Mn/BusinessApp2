package com.example.businessapp2;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class HomePage extends AppCompatActivity {
    ImageView tasks, chatsandcalls, menu, projects, businessplan, invoice, taskshort, salesandexpences;
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        taskshort = findViewById(R.id.taskshort);
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

        taskshort.setOnClickListener(v -> startActivity(new Intent(HomePage.this, NewTask.class)));
    }

    public void onBackPressed(){
        Intent intent = new Intent(HomePage.this, HomePage.class);
        startActivity(intent);
        finish();
    }

}