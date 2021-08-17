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


public class NewTask extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    DatabaseHelper1 databaseHelper1;
    private static String TAG = "NewTask";
    private TextView setDate;
    private CheckBox ongoing, finished;
    private EditText name, description, deliverable, cost;
    private Spinner priority;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Button addtask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        databaseHelper1 = new DatabaseHelper1(this);
        Spinner spinner = findViewById(R.id.spinner);

        name = findViewById(R.id.editTextTextPersonName);
        description = findViewById(R.id.editTextDescription);
        deliverable = findViewById(R.id.editTextDeliverable);
        cost = findViewById(R.id.editTextCost);
        addtask = findViewById(R.id.addtask);
        ongoing = findViewById(R.id.checkBox1);
        finished = findViewById(R.id.checkBox2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.priority,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        setDate = findViewById(R.id.setDate);
        setDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    NewTask.this,
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    mDateSetListener,year, month, day);
            datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            datePickerDialog.show();
        });
        mDateSetListener = (view, year, month, dayOfMonth) -> {
            month += 1;
            Log.d(TAG, "onDateSet: yy/mm/dd" + year + "/" + month + "/" + dayOfMonth);
            String date = year + "/" + month + "/" + dayOfMonth;
            setDate.setText(date);
        };
        addtask.setOnClickListener(v -> {
            String nametext = name.getText().toString();
            String descriptiontext = description.getText().toString();
            String deliverabletext = deliverable.getText().toString();
            String costtext = cost.getText().toString();
            String datetext = setDate.getText().toString();
            String ongoingtext = ongoing.getText().toString();
            String finishedtext = finished.getText().toString();

            Boolean checkinsert = databaseHelper1.insertTaskDetails(nametext, ongoingtext, finishedtext, descriptiontext, deliverabletext, costtext, datetext);
            if (checkinsert == true){
                Toast.makeText(NewTask.this, "Task details added", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(NewTask.this, Tasks.class));
            }else
                Toast.makeText(NewTask.this, " Task details not added", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}