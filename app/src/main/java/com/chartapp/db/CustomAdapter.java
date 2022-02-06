package com.chartapp.db;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chartapp.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    ArrayList<DBData> objDBData;

    public CustomAdapter(ArrayList<DBData> objDBData) {
        this.objDBData = objDBData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View singleRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(singleRow);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    DBData objData = objDBData.get(position);
    holder.name.setText(objData.getName_model());
    }

    @Override
    public int getItemCount() {
        return objDBData == null ? 0 : objDBData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView reffer;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_model);
        }
    }
}