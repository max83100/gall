package com.chartapp.laptop;

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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Laptop extends AppCompatActivity {
    private LaptopAdapter adapter;
    private List<LaptopData> exampleList;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop);
        try {
            fillExampleList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setUpRecyclerView();
        Toolbar toolbar = findViewById(R.id.toolbar_laptop);
        setSupportActionBar(toolbar);



    }
    private void fillExampleList() throws IOException {
        exampleList = new ArrayList<>();
        exampleList.add(new LaptopData(R.drawable.compal, "Compal", "Количество схем - "+6));
        exampleList.add(new LaptopData(R.drawable.acer, "Acer", "Количество схем - "+419));
        exampleList.add(new LaptopData(R.drawable.asus, "Asus", "Количество схем - "+63));
        exampleList.add(new LaptopData(R.drawable.apple, "Apple", "Количество схем - "+3));
        exampleList.add(new LaptopData(R.drawable.aristo, "Aristo", "Количество схем - "+1));
        exampleList.add(new LaptopData(R.drawable.benq, "Benq", "Количество схем - "+8));
        exampleList.add(new LaptopData(R.drawable.clevo, "Clevo", "Количество схем - "+95));
        exampleList.add(new LaptopData(R.drawable.compaq, "Compaq", "Количество схем - "+1));
        exampleList.add(new LaptopData(R.drawable.dns, "DNS", "Количество схем - "+10));
        exampleList.add(new LaptopData(R.drawable.fujitsu, "Fujitsu-Siemens", "Количество схем - "+15));
        exampleList.add(new LaptopData(R.drawable.gateway, "Gateway", "Количество схем - "+21));
        exampleList.add(new LaptopData(R.drawable.gericom, "Gericom", "Количество схем - "+1));
        exampleList.add(new LaptopData(R.drawable.dell, "Dell", "Количество схем - "+106));
        exampleList.add(new LaptopData(R.drawable.hp, "HP", "Количество схем - "+104));
        exampleList.add(new LaptopData(R.drawable.lenovo, "Lenovo", "Количество схем - "+139));
        exampleList.add(new LaptopData(R.drawable.lg, "LG", "Количество схем - "+6));
        exampleList.add(new LaptopData(R.drawable.packard_bell, "Packard Bell", "Количество схем - "+43));
        exampleList.add(new LaptopData(R.drawable.samsung, "Samsung", "Количество схем - "+66));
        exampleList.add(new LaptopData(R.drawable.roverbook, "Roverbook", "Количество схем - "+9));
        exampleList.add(new LaptopData(R.drawable.sony, "Sony", "Количество схем - "+53));


    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.laptop_recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new LaptopAdapter((ArrayList<LaptopData>) exampleList);

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
