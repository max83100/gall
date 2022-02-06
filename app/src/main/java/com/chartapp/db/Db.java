package com.chartapp.db;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chartapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Db extends AppCompatActivity  {


    MyDatabaseHelper myDB;
    ArrayList<DBData> list;
    CustomAdapter customAdapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        recyclerView = findViewById(R.id.recyclerView);

        myDB = new MyDatabaseHelper(this);
        list = new ArrayList<>();
        showData(recyclerView);


    }
    public void showData(View view){
        try {
            list = myDB.getAllData();
            CustomAdapter customAdapter = new CustomAdapter(list);
            recyclerView.hasFixedSize();
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(customAdapter);
        } catch (Exception e) {
            Toast.makeText(this, "show data"+e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }




}