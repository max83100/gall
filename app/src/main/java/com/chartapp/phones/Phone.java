package com.chartapp.phones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;


import com.chartapp.R;
import com.chartapp.phones.phone_adapter.PhoneAdapter;
import com.chartapp.phones.phone_adapter.PhoneData;

import java.util.ArrayList;
import java.util.List;


public class Phone extends AppCompatActivity {

    private PhoneAdapter adapter;
    private List<PhoneData> exampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        fillExampleList();
        setUpRecyclerView();


    }
    private void fillExampleList() {
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


}

