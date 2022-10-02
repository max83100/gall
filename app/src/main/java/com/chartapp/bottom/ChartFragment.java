package com.chartapp.bottom;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.chartapp.R;
import com.chartapp.laptop.Laptop;
import com.chartapp.mainboard.Mainboard;
import com.chartapp.monitors.Monitor;
import com.chartapp.phones.Phone;
import com.chartapp.power.Power;
import com.chartapp.videocard.Videocard;
import com.chartapp.welding.Welding;

public class ChartFragment extends Fragment {
    Intent intent;



    public ChartFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_chart, container, false);
        getActivity().setTitle("Каталог схем");
        ImageView laptop = view.findViewById(R.id.notebookView);
        ImageView mainboard = view.findViewById(R.id.mainboardView);
        ImageView phone = view.findViewById(R.id.phoneView);
        ImageView welding = view.findViewById(R.id.weldingView);
        ImageView power = view.findViewById(R.id.powersupView);
        ImageView videocard = view.findViewById(R.id.vidrocaardView);
        ImageView monitors = view.findViewById(R.id.monitorView);

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Phone.class);
                startActivity(intent);
            }
        });

        mainboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Mainboard.class);
                startActivity(intent);
            }
        });

        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Laptop.class);
                startActivity(intent);
            }
        });
        welding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Welding.class);
                startActivity(intent);
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Power.class);
                startActivity(intent);
            }
        });
        videocard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Videocard.class);
                startActivity(intent);
            }
        });
        monitors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), Monitor.class);
                startActivity(intent);
            }
        });




        return view;
    }

}