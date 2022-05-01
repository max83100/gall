package com.chartapp;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> implements Filterable {
        ArrayList<Data> objData;
        Intent intent;

private List<Data> exampleListFull;


public Adapter(ArrayList<Data> objData) {
        this.objData = objData;
        exampleListFull = new ArrayList<>(objData);

        }


@NonNull
@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View singleRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        return new MyViewHolder(singleRow);
        }

@Override
public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Data objData = this.objData.get(position);
        holder.name.setText(objData.getName());
        holder.other.setText(objData.getOther());
        holder.name.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(objData.getRef()));
        v.getContext().startActivity(Adapter.this.intent);

        }
        });

        }

@Override
public int getItemCount() {
        return objData == null ? 0 : objData.size();
        }

public static class MyViewHolder extends RecyclerView.ViewHolder{
    TextView name;
    TextView other;



    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        other = itemView.findViewById(R.id.other);


    }
}
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Data> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Data item : exampleListFull) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            objData.clear();
            objData.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };

}