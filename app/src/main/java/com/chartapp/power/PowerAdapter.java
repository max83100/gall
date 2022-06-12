package com.chartapp.power;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chartapp.R;


import java.util.ArrayList;
import java.util.List;

public class PowerAdapter extends RecyclerView.Adapter<PowerAdapter.ViewHolder> implements Filterable {

    private List<PowerData> exampleList;
    private List<PowerData> exampleListFull;


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

    public PowerAdapter(List<PowerData> exampleList) {
        this.exampleList = exampleList;
        exampleListFull = new ArrayList<>(exampleList);

    }

    @NonNull
    @Override
    public PowerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.catalog,
                parent, false);
        return new PowerAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PowerAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        PowerData currentItem = exampleList.get(position);

        holder.imageView.setImageResource(currentItem.getImageView());
        holder.textView1.setText(currentItem.getName());
        holder.textView2.setText(currentItem.getCount());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Power_catalog.class);
                switch (position){
                    case 0:
                        intent.putExtra("testNameData", "atx");
                        break;
                    case 1:
                        intent.putExtra("testNameData", "cheftec");
                        break;
                    case 2:
                        intent.putExtra("testNameData", "colorsit");
                        break;
                    case 3:
                        intent.putExtra("testNameData", "coolermaster");
                        break;
                    case 4:
                        intent.putExtra("testNameData", "corsair");
                        break;
                    case 5:
                        intent.putExtra("testNameData", "cwt");
                        break;
                    case 6:
                        intent.putExtra("testNameData", "dell");
                        break;
                    case 7:
                        intent.putExtra("testNameData", "delta");
                        break;
                    case 8:
                        intent.putExtra("testNameData", "dtk");
                        break;
                    case 9:
                        intent.putExtra("testNameData", "fsp");
                        break;
                    case 10:
                        intent.putExtra("testNameData", "green");
                        break;
                    case 11:
                        intent.putExtra("testNameData", "jnc");
                        break;
                    case 12:
                        intent.putExtra("testNameData", "laptop");
                        break;
                    case 13:
                        intent.putExtra("testNameData", "liteon");
                        break;
                    case 14:
                        intent.putExtra("testNameData", "maxpower");
                        break;
                    case 15:
                        intent.putExtra("testNameData", "microlab");
                        break;
                    case 16:
                        intent.putExtra("testNameData", "powerman");
                        break;
                    case 17:
                        intent.putExtra("testNameData", "powermaster");
                        break;
                    case 18:
                        intent.putExtra("testNameData", "seventeam");
                        break;
                    case 19:
                        intent.putExtra("testNameData", "thermaltake");
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
            List<PowerData> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (PowerData item : exampleListFull) {
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
