package com.chartapp.bottom;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chartapp.R;
import com.chartapp.phones.Phone;

public class SoftFragment extends Fragment  {
    Intent intent;
    Uri address;
    ImageView acrobat_play_market;
    ImageView google_drive;
    ImageView acrobat_drive;
    ImageView reader_play_market;
    ImageView reader_drive;

    ImageView cad_pockets_drive;
    ImageView cad_pockets_play_market;
    ImageView dwg_fastview_play_market;
    ImageView dwg_fastview_drive;
    ImageView gna_cad_drive;
    ImageView gna_cad_play_market;


    public SoftFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_soft, container, false);
        getActivity().setTitle("Софт");
//PDF
        acrobat_play_market = view.findViewById(R.id.acrobat_play_market);
        google_drive = view.findViewById(R.id.google_drive);
        acrobat_drive = view.findViewById(R.id.acrobat_drive);
        reader_play_market = view.findViewById(R.id.reader_play_market);
        reader_drive = view.findViewById(R.id.reader_drive);
//Boardview
        //cad_pockets_drive = view.findViewById(R.id.cad_pockets_drive);
        cad_pockets_play_market = view.findViewById(R.id.cad_pockets_play_market);
        dwg_fastview_play_market = view.findViewById(R.id.dwg_fastview_play_market);
        //dwg_fastview_drive = view.findViewById(R.id.dwg_fastview_drive);
        gna_cad_drive = view.findViewById(R.id.gna_cad_drive);
        gna_cad_play_market = view.findViewById(R.id.gna_cad_play_market);



        handleClick(view);

        return view;
    }


    public void handleClick(View v){
        //PDF
        acrobat_play_market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address = Uri.parse(
                        "https://play.google.com/store/apps/details?id=com.adobe.reader");
                intent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(intent);
            }
        });

        acrobat_drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address = Uri.parse(
                        "https://drive.google.com/drive/folders/1dC_Fsh4lX_XI6tebOWZbD3TeTx9PCYV-?usp=sharing");
                intent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(intent);
            }
        });

        google_drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address = Uri.parse(
                        "https://drive.google.com/drive/folders/1PIuYMplLeBMtrxi-Ib4K1MRV10ItsMKy?usp=sharing");
                intent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(intent);
            }
        });

        reader_play_market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address = Uri.parse(
                        "https://play.google.com/store/apps/details?id=pdf.reader");
                intent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(intent);
            }
        });

        reader_drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address = Uri.parse(
                        "https://drive.google.com/drive/folders/1vaLfSnm7gmBW-IG5KJ2vgbrcNgpy47RK?usp=sharing");
                intent = new Intent(Intent.ACTION_VIEW, address);

                startActivity(intent);
            }
        });

        //Boardview
       /* cad_pockets_drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address = Uri.parse(
                        "https://drive.google.com/drive/folders/1XvM9N1Y_ylKHKi6JoNludGuBR1VFiQeI?usp=sharing");
                intent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(intent);
            }
        });

        */

        cad_pockets_play_market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address = Uri.parse(
                        "https://play.google.com/store/apps/details?id=com.ZWSoft.ZWCAD#");
                intent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(intent);
            }
        });

        dwg_fastview_play_market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address = Uri.parse(
                        "https://play.google.com/store/apps/details?id=com.gstarmc.android");
                intent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(intent);
            }
        });

        /*dwg_fastview_drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address = Uri.parse(
                        "https://drive.google.com/drive/folders/1YYErp1QOdZS3EZnUhGMPSyCZerNpMM27?usp=sharing");
                intent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(intent);
            }
        });

         */

        gna_cad_drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address = Uri.parse(
                        "https://drive.google.com/drive/folders/1rkaQSCs6yercuKArhtR7sYmV1Y5km_0j?usp=sharing");
                intent = new Intent(Intent.ACTION_VIEW, address);

                startActivity(intent);
            }
        });
        gna_cad_play_market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address = Uri.parse(
                        "https://play.google.com/store/apps/details?id=com.gna.cad&hl=ru");
                intent = new Intent(Intent.ACTION_VIEW, address);

                startActivity(intent);
            }
        });
    }
}