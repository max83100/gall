package com.chartapp.phones.phone_adapter;

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

import com.chartapp.MainActivity;
import com.chartapp.R;
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
import com.chartapp.phones.xiaomi.XiaomiCatalog;

import java.util.ArrayList;
import java.util.List;


public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ExampleViewHolder> implements Filterable {
private List<PhoneData> exampleList;
private List<PhoneData> exampleListFull;

class ExampleViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView1;
    TextView textView2;

    ExampleViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.piccatalog);
        textView1 = itemView.findViewById(R.id.namecatalog);
        textView2 = itemView.findViewById(R.id.countcatalog);
    }
}

    public PhoneAdapter(List<PhoneData> exampleList) {
        this.exampleList = exampleList;
        exampleListFull = new ArrayList<>(exampleList);
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.catalog,
                parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        PhoneData currentItem = exampleList.get(position);

        holder.imageView.setImageResource(currentItem.getImageView());
        holder.textView1.setText(currentItem.getName());
        holder.textView2.setText(currentItem.getCount());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            Intent intent;
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        intent = new Intent(v.getContext(), XiaomiCatalog.class);
                        break;
                    case 1:
                        intent = new Intent(v.getContext(), Apple_catalog.class);
                        break;
                    case 2:
                        intent = new Intent(v.getContext(), Asus_catalog.class);
                        break;
                    case 3:
                        intent = new Intent(v.getContext(), Samsung_catalog.class);
                        break;
                    case 4:
                        intent = new Intent(v.getContext(), Huawei_catalog.class);
                        break;
                    case 5:
                        intent = new Intent(v.getContext(), Blackberry_catalog.class);
                        break;
                    case 6:
                        intent = new Intent(v.getContext(), Meizu_catalog.class);
                        break;
                    case 7:
                        intent = new Intent(v.getContext(), Oppo_catalog.class);
                        break;
                    case 8:
                        intent = new Intent(v.getContext(), Nokia_catalog.class);
                        break;
                    case 9:
                        intent = new Intent(v.getContext(), Lg_catalog.class);
                        break;
                    case 10:
                        intent = new Intent(v.getContext(), Lenovo_catalog.class);
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
            List<PhoneData> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (PhoneData item : exampleListFull) {
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