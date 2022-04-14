package com.chartapp.bottom;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.chartapp.R;

public class OtherFragment extends Fragment {
    Intent intent;
    Uri address;
    Button telegram_btn;
    Button pikabu_btn;
    Button whatsapp_btn;


    public OtherFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_other, container, false);
        getActivity().setTitle("Контакты");
        telegram_btn = view.findViewById(R.id.telegram_btn);
        pikabu_btn = view.findViewById(R.id.pikabu_btn);
        whatsapp_btn = view.findViewById(R.id.whatsapp_btn);
        handleClick(view);
        return view;
    }

    private void handleClick(View view) {
        telegram_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address = Uri.parse(
                        "https://t.me/chart_app");
                intent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(intent);
            }
        });

        whatsapp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address = Uri.parse(
                        "https://chat.whatsapp.com/By0Dq2I40RV4QyhoTIeVzt");
                intent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(intent);
            }
        });

        pikabu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address = Uri.parse(
                        "https://pikabu.ru/@JustWeld");
                intent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(intent);
            }
        });
    }
}