package com.chartapp.videocard;

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

import com.chartapp.CommonData;
import com.chartapp.R;


import java.util.ArrayList;
import java.util.List;

public class VideocardAdapter extends RecyclerView.Adapter<VideocardAdapter.ViewHolder> implements Filterable {

    private List<CommonData> exampleList;
    private List<CommonData> exampleListFull;


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

    public VideocardAdapter(ArrayList<CommonData> exampleList) {
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
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CommonData currentItem = exampleList.get(position);

        holder.imageView.setImageResource(currentItem.getImageView());
        holder.textView1.setText(currentItem.getName());
        holder.textView2.setText(currentItem.getCount());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Videocard_catalog.class);
                switch (position){
                    case 0:
                        intent.putExtra("testNameData", "amd");
                        break;
                    case 1:
                        intent.putExtra("testNameData", "asus");
                        break;
                    case 2:
                        intent.putExtra("testNameData", "colorful");
                        break;
                    case 3:
                        intent.putExtra("testNameData", "galaxy");
                        break;
                    case 4:
                        intent.putExtra("testNameData", "gigabyte");
                        break;
                    case 5:
                        intent.putExtra("testNameData", "msi");
                        break;
                    case 6:
                        intent.putExtra("testNameData", "nvidia");
                        break;
                    case 7:
                        intent.putExtra("testNameData", "palit");
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
            List<CommonData> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (CommonData item : exampleListFull) {
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