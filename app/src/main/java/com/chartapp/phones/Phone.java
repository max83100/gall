package com.chartapp.phones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;


import com.chartapp.R;
import com.chartapp.phones.phone_adapter.PhoneAdapter;
import com.chartapp.phones.phone_adapter.PhoneData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Phone extends AppCompatActivity  {

    private PhoneAdapter adapter;
    private List<PhoneData> exampleList;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        try {
            fillExampleList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setUpRecyclerView();
        Toolbar toolbar = findViewById(R.id.toolbar_phone);
        setSupportActionBar(toolbar);



    }
    private void fillExampleList() throws IOException {
        exampleList = new ArrayList<>();
        exampleList.add(new PhoneData(R.drawable.xiaomi, "Xiaomi", "Количество схем - "+55));
        exampleList.add(new PhoneData(R.drawable.apple, "Apple", "Количество схем - "+26));
        exampleList.add(new PhoneData(R.drawable.asus, "Asus", "Количество схем - "+21));
        exampleList.add(new PhoneData(R.drawable.samsung, "Samsung", "Количество схем - "+88));
        exampleList.add(new PhoneData(R.drawable.huawei, "Huawei", "Количество схем - "+55));
        exampleList.add(new PhoneData(R.drawable.blackberry, "Blackberry", "Количество схем - "+6));
        exampleList.add(new PhoneData(R.drawable.meizu, "Meizu", "Количество схем - "+8));
        exampleList.add(new PhoneData(R.drawable.oppo, "OPPO", "Количество схем - "+20));
        exampleList.add(new PhoneData(R.drawable.nokia, "Nokia", "Количество схем - "+73));
        exampleList.add(new PhoneData(R.drawable.lg, "LG", "Количество схем - "+5));
        exampleList.add(new PhoneData(R.drawable.lenovo, "Lenovo", "Количество схем - "+86));

    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.phone_recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new PhoneAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
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

                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }





}

