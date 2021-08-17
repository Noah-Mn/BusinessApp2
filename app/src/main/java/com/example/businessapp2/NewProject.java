package com.example.businessapp2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class NewProject extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG2 = "New Project";
     TextView psetDate;
     CheckBox pongoing, pfinished;
     EditText name, description, product, cost;
     Spinner priority;
     DatePickerDialog.OnDateSetListener mDateSetListener;
     Button addproject;
     DatabaseHelper2 databaseHelper2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_project);
        Spinner spinner = findViewById(R.id.spinner);
        databaseHelper2 = new DatabaseHelper2(this);
        name = findViewById(R.id.projectName);
        description = findViewById(R.id.pDescription);
        product = findViewById(R.id.products);
        cost = findViewById(R.id.pCost);
        addproject = findViewById(R.id.addprojectp);
        pongoing = findViewById(R.id.pcheckBox1);
        pfinished = findViewById(R.id.pcheckBox2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.priority,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        psetDate = findViewById(R.id.psetDate);
        psetDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    NewProject.this,
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    mDateSetListener,year, month, day);
            datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            datePickerDialog.show();
        });
        mDateSetListener = (view, year, month, dayOfMonth) -> {
            month += 1;
            Log.d(TAG2, "onDateSet: yy/mm/dd" + year + "/" + month + "/" + dayOfMonth);
            String date = year + "/" + month + "/" + dayOfMonth;
            psetDate.setText(date);
        };
        addproject.setOnClickListener(v -> {
                String nametext = name.getText().toString();
                String descriptiontext = description.getText().toString();
                String producttext = product.getText().toString();
                String costtext = cost.getText().toString();
                String datetext = psetDate.getText().toString();
                String ongoingtext = pongoing.getText().toString();
                String finishedtext = pfinished.getText().toString();

                Boolean checkProjectName = databaseHelper2.checkProjectName(nametext);
                if (checkProjectName) {
                    Boolean checkinsert = databaseHelper2.insertProjectDetails(nametext, ongoingtext, finishedtext, descriptiontext, producttext, costtext, datetext);
                    if (checkinsert) {
                        Toast.makeText(NewProject.this, "Project details added", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(NewProject.this, Projects.class));
                    } else
                        Toast.makeText(NewProject.this, " Project details not added", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(NewProject.this, "Project details not added", Toast.LENGTH_SHORT).show();
                }
                });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}