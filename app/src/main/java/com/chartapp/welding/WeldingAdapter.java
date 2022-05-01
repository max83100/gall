package com.chartapp.welding;

import android.annotation.SuppressLint;
import android.content.Intent;
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

import com.chartapp.R;
import com.chartapp.phones.Phone_catalog;


import java.util.ArrayList;
import java.util.List;


public class WeldingAdapter extends RecyclerView.Adapter<WeldingAdapter.ViewHolder> implements Filterable {
    private List<WeldingData> exampleList;
    private List<WeldingData> exampleListFull;


    public WeldingAdapter(List<WeldingData> exampleList) throws ClassNotFoundException {
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
        WeldingData currentItem = exampleList.get(position);
        holder.imageView.setImageResource(currentItem.getImageView());
        holder.textView1.setText(currentItem.getName());
        holder.textView2.setText(currentItem.getCount());


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
            List<WeldingData> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (WeldingData item : exampleListFull) {
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


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView1;
        TextView textView2;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.piccatalog);
            textView1 = itemView.findViewById(R.id.namecatalog);
            textView2 = itemView.findViewById(R.id.countcatalog);
            imageView.setOnClickListener( this);
            textView1.setOnClickListener( this);
            textView2.setOnClickListener( this);

        }

        @Override
        public void onClick(View v) {
            int pos = getLayoutPosition();
            Intent intent = new Intent(v.getContext(), Welding_catalog.class);
            switch (pos) {
                case 0:
                    intent.putExtra("testNameData", "kedr");
                    break;
                case 1:
                    intent.putExtra("testNameData", "ptk");
                    break;
                case 2:
                    intent.putExtra("testNameData", "solaris");
                    break;
                case 3:
                    intent.putExtra("testNameData", "gladiator");
                    break;
                case 4:
                    intent.putExtra("testNameData", "kalibr");
                    break;
                case 5:
                    intent.putExtra("testNameData", "kontur");
                    break;
                case 6:
                    intent.putExtra("testNameData", "linkor");
                    break;
                case 7:
                    intent.putExtra("testNameData", "mangust");
                    break;
                case 8:
                    intent.putExtra("testNameData", "neon");
                    break;
                case 9:
                    intent.putExtra("testNameData", "pdg");
                    break;
                case 10:
                    intent.putExtra("testNameData", "piton");
                    break;
                case 11:
                    intent.putExtra("testNameData", "pulsar");
                    break;
                case 12:
                    intent.putExtra("testNameData", "resanta");
                    break;
                case 13:
                    intent.putExtra("testNameData", "rikon");
                    break;
                case 14:
                    intent.putExtra("testNameData", "svarog");
                    break;
                case 15:
                    intent.putExtra("testNameData", "sputnik");
                    break;
                case 16:
                    intent.putExtra("testNameData", "termit");
                    break;
                case 17:
                    intent.putExtra("testNameData", "technotron");
                    break;
                case 18:
                    intent.putExtra("testNameData", "torus");
                    break;
                case 19:
                    intent.putExtra("testNameData", "feb");
                    break;
                case 20:
                    intent.putExtra("testNameData", "forsazh");
                    break;
                case 21:
                    intent.putExtra("testNameData", "ciklon");
                    break;
                case 22:
                    intent.putExtra("testNameData", "aotai");
                    break;
                case 23:
                    intent.putExtra("testNameData", "aurora");
                    break;
                case 24:
                    intent.putExtra("testNameData", "blueweld");
                    break;
                case 25:
                    intent.putExtra("testNameData", "bestweld");
                    break;
                case 26:
                    intent.putExtra("testNameData", "brima");
                    break;
                case 27:
                    intent.putExtra("testNameData", "cebora");
                    break;
                case 28:
                    intent.putExtra("testNameData", "cemont");
                    break;
                case 29:
                    intent.putExtra("testNameData", "china");
                    break;
                case 30:
                    intent.putExtra("testNameData", "deca");
                    break;
                case 31:
                    intent.putExtra("testNameData", "edon");
                    break;
                case 32:
                    intent.putExtra("testNameData", "esab");
                    break;
                case 33:
                    intent.putExtra("testNameData", "ewm");
                    break;
                case 34:
                    intent.putExtra("testNameData", "foxweld");
                    break;
                case 35:
                    intent.putExtra("testNameData", "fronius");
                    break;
                case 36:
                    intent.putExtra("testNameData", "fubag");
                    break;
                case 37:
                    intent.putExtra("testNameData", "gys");
                    break;
                case 38:
                    intent.putExtra("testNameData", "hitachi");
                    break;
                case 39:
                    intent.putExtra("testNameData", "hyperterm");
                    break;
                case 40:
                    intent.putExtra("testNameData", "ine");
                    break;
                case 41:
                    intent.putExtra("testNameData", "kemppi");
                    break;
                case 42:
                    intent.putExtra("testNameData", "kende");
                    break;
                case 43:
                    intent.putExtra("testNameData", "lincoln");
                    break;
                case 44:
                    intent.putExtra("testNameData", "migatronic");
                    break;
                case 45:
                    intent.putExtra("testNameData", "murex");
                    break;
                case 46:
                    intent.putExtra("testNameData", "nebula");
                    break;
                case 47:
                    intent.putExtra("testNameData", "profhelper");
                    break;
                case 48:
                    intent.putExtra("testNameData", "quattro");
                    break;
                case 49:
                    intent.putExtra("testNameData", "redbo");
                    break;
                case 50:
                    intent.putExtra("testNameData", "russia");
                    break;
                case 51:
                    intent.putExtra("testNameData", "selma");
                    break;
                case 52:
                    intent.putExtra("testNameData", "sip");
                    break;
                case 53:
                    intent.putExtra("testNameData", "start");
                    break;
                case 54:
                    intent.putExtra("testNameData", "sturm");
                    break;
                case 55:
                    intent.putExtra("testNameData", "telwin");
                    break;
                case 56:
                    intent.putExtra("testNameData", "thermal");
                    break;
                case 57:
                    intent.putExtra("testNameData", "torros");
                    break;
                case 58:
                    intent.putExtra("testNameData", "wester");
                    break;

            }
            v.getContext().startActivity(intent);

        }

    }
}
