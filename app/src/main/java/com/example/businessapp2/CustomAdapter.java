package com.example.businessapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

   private final Context context;
   private final ArrayList name;
    private final ArrayList deadline;
    private final ArrayList description;

    CustomAdapter(Context context, ArrayList name, ArrayList deadline, ArrayList description){
        this.context = context;
        this.name = name;
        this.deadline = deadline;
        this.description = description;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
       View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(String.valueOf(name.get(position)));
        holder.Deadline.setText(String.valueOf(deadline.get(position)));
        holder.textDescription.setText(String.valueOf(description.get(position)));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, Deadline, textDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            Deadline = itemView.findViewById(R.id.Deadline);
            textDescription = itemView.findViewById(R.id.textDescription);
        }
    }
}
