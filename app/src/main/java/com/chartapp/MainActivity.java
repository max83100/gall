package com.chartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chartapp.laptop.Laptop;
import com.chartapp.mainboard.Mainboard;
import com.chartapp.phones.Phone;
import com.chartapp.power.Power;
import com.chartapp.welding.Welding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.phoneView:
                intent = new Intent(this, Phone.class);
                break;
            case R.id.notebookView:
                intent = new Intent(this, Laptop.class);
                break;
            case R.id.mainboardView:
                intent = new Intent(this, Mainboard.class);
                break;
            case R.id.weldingView:
                intent = new Intent(this, Welding.class);
                break;
            case R.id.powerView:
                intent = new Intent(this, Power.class);
                break;
        }
        startActivity(intent);

    }
}