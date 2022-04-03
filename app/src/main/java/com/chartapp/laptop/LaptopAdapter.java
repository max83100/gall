package com.chartapp.laptop;

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
import com.chartapp.laptop.acer.Acer_laptop_catalog;
import com.chartapp.laptop.apple.Apple_laptop_catalog;
import com.chartapp.laptop.aristo.Aristo_laptop_catalog;
import com.chartapp.laptop.asus.Asus_laptop_catalog;
import com.chartapp.laptop.benq.Benq_laptop_catalog;
import com.chartapp.laptop.clevo.Clevo_laptop_catalog;
import com.chartapp.laptop.compal.Compal_laptop_catalog;
import com.chartapp.laptop.compaq.Compaq_laptop_catalog;
import com.chartapp.laptop.dell.Dell_laptop_catalog;
import com.chartapp.laptop.dns.Dns_laptop_catalog;
import com.chartapp.laptop.fujitsu.Fujitsu_laptop_catalog;
import com.chartapp.laptop.gateway.Gateway_laptop_catalog;
import com.chartapp.laptop.gericom.Gericom_laptop_catalog;
import com.chartapp.laptop.hp.Hp_laptop_catalog;
import com.chartapp.laptop.lenovo.Lenovo_laptop_catalog;
import com.chartapp.laptop.lg.Lg_laptop_catalog;
import com.chartapp.laptop.packardbell.Packard_catalog_laptop;
import com.chartapp.laptop.roverbook.Roverbook_laptop_catalog;
import com.chartapp.laptop.samsung.Samsung_laptop_catalog;
import com.chartapp.laptop.sony.Sony_laptop_catalog;
import com.chartapp.phones.apple.Apple_catalog;
import com.chartapp.phones.asus.Asus_catalog;
import com.chartapp.phones.blackberry.Blackberry_catalog;
import com.chartapp.phones.huawei.Huawei_catalog;
import com.chartapp.phones.lenovo.Lenovo_catalog;
import com.chartapp.phones.lg.Lg_catalog;
import com.chartapp.phones.meizu.Meizu_catalog;
import com.chartapp.phones.nokia.Nokia_catalog;
import com.chartapp.phones.oppo.Oppo_catalog;
import com.chartapp.phones.samsung.Samsung_catalog;


import java.util.ArrayList;
import java.util.List;


public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.ViewHolder> implements Filterable {
    private List<LaptopData> exampleList;
    private List<LaptopData> exampleListFull;

    public LaptopAdapter() {

    }

    class ViewHolder extends RecyclerView.ViewHolder {
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

    public LaptopAdapter(List<LaptopData> exampleList) {
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
            Intent intent;
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        intent = new Intent(v.getContext(), Compal_laptop_catalog.class);
                        break;
                    case 1:
                        intent = new Intent(v.getContext(), Acer_laptop_catalog.class);
                        break;
                    case 2:
                        intent = new Intent(v.getContext(), Asus_laptop_catalog.class);
                        break;
                    case 3:
                        intent = new Intent(v.getContext(), Apple_laptop_catalog.class);
                        break;
                    case 4:
                        intent = new Intent(v.getContext(), Aristo_laptop_catalog.class);
                        break;
                    case 5:
                        intent = new Intent(v.getContext(), Benq_laptop_catalog.class);
                        break;
                    case 6:
                        intent = new Intent(v.getContext(), Clevo_laptop_catalog.class);
                        break;
                    case 7:
                        intent = new Intent(v.getContext(), Compaq_laptop_catalog.class);
                        break;
                    case 8:
                        intent = new Intent(v.getContext(), Dns_laptop_catalog.class);
                        break;
                    case 9:
                        intent = new Intent(v.getContext(), Fujitsu_laptop_catalog.class);
                        break;
                    case 10:
                        intent = new Intent(v.getContext(), Gateway_laptop_catalog.class);
                        break;
                    case 11:
                        intent = new Intent(v.getContext(), Gericom_laptop_catalog.class);
                        break;
                    case 12:
                        intent = new Intent(v.getContext(), Dell_laptop_catalog.class);
                        break;
                    case 13:
                        intent = new Intent(v.getContext(), Hp_laptop_catalog.class);
                        break;
                    case 14:
                        intent = new Intent(v.getContext(), Lenovo_laptop_catalog.class);
                        break;
                    case 15:
                        intent = new Intent(v.getContext(), Lg_laptop_catalog.class);
                        break;
                    case 16:
                        intent = new Intent(v.getContext(), Packard_catalog_laptop.class);
                        break;
                    case 17:
                        intent = new Intent(v.getContext(), Samsung_laptop_catalog.class);
                        break;
                    case 18:
                        intent = new Intent(v.getContext(), Roverbook_laptop_catalog.class);
                        break;
                    case 19:
                        intent = new Intent(v.getContext(), Sony_laptop_catalog.class);
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