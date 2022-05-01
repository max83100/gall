package com.chartapp.laptop;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chartapp.Data;
import com.chartapp.MainActivity;
import com.chartapp.R;

import java.util.ArrayList;
import java.util.List;


public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.ViewHolder> implements Filterable {

    private ArrayList<LaptopData> exampleList;
    private List<LaptopData> exampleListFull;


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1;
        TextView textView2;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.piccatalog);
            textView1 = itemView.findViewById(R.id.namecatalog);
            textView2 = itemView.findViewById(R.id.countcatalog);
        }
    }

    public LaptopAdapter(ArrayList<LaptopData> exampleList) {
        this.exampleList = exampleList;
        exampleListFull = new ArrayList<>(exampleList);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.catalog,
                parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LaptopAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        LaptopData currentItem = exampleList.get(position);

        holder.imageView.setImageResource(currentItem.getImageView());
        holder.textView1.setText(currentItem.getName());
        holder.textView2.setText(currentItem.getCount());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Laptop_catalog.class);
                switch (position){
                    case 0:
                        intent.putExtra("testNameData", "compal");
                        break;
                    case 1:
                        intent.putExtra("testNameData", "acer");
                        break;
                    case 2:
                        intent.putExtra("testNameData", "asus");
                        break;
                    case 3:
                        intent.putExtra("testNameData", "apple");
                        break;
                    case 4:
                        intent.putExtra("testNameData", "aristo");
                        break;
                    case 5:
                        intent.putExtra("testNameData", "benq");
                        break;
                    case 6:
                        intent.putExtra("testNameData", "clevo");
                        break;
                    case 7:
                        intent.putExtra("testNameData", "compaq");
                        break;
                    case 8:
                        intent.putExtra("testNameData", "dns");
                        break;
                    case 9:
                        intent.putExtra("testNameData", "fujitsu");
                        break;
                    case 10:
                        intent.putExtra("testNameData", "gateway");
                        break;
                    case 11:
                        intent.putExtra("testNameData", "gericom");
                        break;
                    case 12:
                        intent.putExtra("testNameData", "dell");
                        break;
                    case 13:
                        intent.putExtra("testNameData", "hp");
                        break;
                    case 14:
                        intent.putExtra("testNameData", "lenovo");
                        break;
                    case 15:
                        intent.putExtra("testNameData", "lg");
                        break;
                    case 16:
                        intent.putExtra("testNameData", "packardbell");
                        break;
                    case 17:
                        intent.putExtra("testNameData", "samsung");
                        break;
                    case 18:
                        intent.putExtra("testNameData", "roverbook");
                        break;
                    case 19:
                        intent.putExtra("testNameData", "sony");
                        break;

                }

                v.getContext().startActivity(intent);

            }
        });
    }




    @Override
    public int getItemCount() {
        return exampleList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<LaptopData> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (LaptopData item : exampleListFull) {
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
            exampleList.clear();
            exampleList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


}