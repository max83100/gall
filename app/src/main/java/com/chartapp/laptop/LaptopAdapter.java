package com.chartapp.laptop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chartapp.R;


public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.ViewHolder> {
    LaptopData[] LaptopData;
    Context context;

    public LaptopAdapter(LaptopData[] LaptopData, Laptop activity) {
        this.LaptopData = LaptopData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.product_card,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final LaptopData product_const = LaptopData[position];
        holder.productName.setText(product_const.getproductName());
        holder.productDate.setText(product_const.getproductDate());

    }

    @Override
    public int getItemCount() {
        return LaptopData.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView productName;
        TextView productDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.namecatalog);
            productDate = itemView.findViewById(R.id.countcatalog);

        }
    }

}

