package com.chartapp.welding.start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.Toast;

import com.chartapp.R;
import com.chartapp.phones.Adapter;
import com.chartapp.phones.Data;
import com.chartapp.welding.kedr.KedrDatabaseHelper;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {

    StartDatabaseHelper myDB;
    ArrayList<Data> list;
    Adapter customAdapter;
    RecyclerView recyclerView;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welding);
        recyclerView = findViewById(R.id.welding_recycler);
        myDB = new StartDatabaseHelper(this);
        list = new ArrayList<>();
        showData(recyclerView);
        Toolbar toolbar = findViewById(R.id.welding_toolbar);
        setSupportActionBar(toolbar);

    }
    public void showData(View view){
        try {
            list = myDB.getAllData();
            customAdapter = new Adapter(list);
            recyclerView.hasFixedSize();
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(customAdapter);
        } catch (Exception e) {
            Toast.makeText(this, "show data"+e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                customAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}