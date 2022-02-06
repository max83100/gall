package com.chartapp.mainboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chartapp.R;


public class MainboardAdapter extends RecyclerView.Adapter<MainboardAdapter.ViewHolder> {
    MainboardData[] MainboardData;
    Context context;

    public MainboardAdapter(MainboardData[] MainboardData, Mainboard activity) {
        this.MainboardData = MainboardData;
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
        final MainboardData product_const = MainboardData[position];
        holder.productName.setText(product_const.getproductName());
        holder.productDate.setText(product_const.getproductDate());

    }

    @Override
    public int getItemCount() {
        return MainboardData.length;
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

