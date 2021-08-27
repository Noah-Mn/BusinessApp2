package com.example.businessapp2;

import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Tasks extends AppCompatActivity {
    ImageView tasks, chatsandcalls, menu, projects, businessplan, invoice, salesandexpences;
    SearchView searchView;
    Button addTask;
    RecyclerView recyclerView;
    DatabaseHelper1 databaseHelper1;
    ArrayList<String> name, deadline, description;
    CustomAdapter customAdapter;

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
        searchView = findViewById(R.id.searchView);
        addTask = findViewById(R.id.addTask);
        recyclerView = findViewById(R.id.recyclerView);

        databaseHelper1 = new DatabaseHelper1(this);
        name = new ArrayList<>();
        deadline = new ArrayList<>();
        description = new ArrayList<>();

        storeTasks();

        customAdapter = new CustomAdapter(this, name, deadline, description);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addTask.setOnClickListener(v -> startActivity(new Intent(Tasks.this, NewTask.class)));

        businessplan.setOnClickListener(v -> startActivity(new Intent(Tasks.this, BusinessPlan.class)));

        chatsandcalls.setOnClickListener(v -> startActivity(new Intent(Tasks.this, Chats_and_Calls.class)));

        invoice.setOnClickListener(v -> startActivity(new Intent(Tasks.this, Invoice.class)));

        salesandexpences.setOnClickListener(v -> startActivity(new Intent(Tasks.this, SalesAndExpences.class)));

        menu.setOnClickListener(v -> startActivity(new Intent(Tasks.this, Menu.class)));

        tasks.setOnClickListener(v -> startActivity(new Intent(Tasks.this, Tasks.class)));

        projects.setOnClickListener(v -> startActivity(new Intent(Tasks.this, Projects.class)));

        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        return false;
                    }
                }
        );

        Intent intent = getIntent();
        if(Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }
    }

    private void doMySearch(String query) {
    }
    void storeTasks(){
        Cursor cursor = databaseHelper1.getdata();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data to display", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                name.add(cursor.getString(0));
                description.add(cursor.getString(1));
                deadline.add(cursor.getString(2));
            }
        }
    }
    public void onBackPressed(){
        Intent intent = new Intent(Tasks.this, HomePage.class);
        startActivity(intent);
        finish();
    }
}