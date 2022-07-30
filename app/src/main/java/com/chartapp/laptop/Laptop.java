package com.chartapp.laptop;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chartapp.R;
import com.yandex.mobile.ads.banner.AdSize;
import com.yandex.mobile.ads.banner.BannerAdView;
import com.yandex.mobile.ads.common.AdRequest;
import com.yandex.mobile.ads.common.InitializationListener;
import com.yandex.mobile.ads.common.MobileAds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Laptop extends AppCompatActivity {
    private LaptopAdapter adapter;
    private List<LaptopData> exampleList;
    BannerAdView mBannerAdView;
    private static final String YANDEX_MOBILE_ADS_TAG = "YandexMobileAds";



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
        try {
            setUpRecyclerView();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Toolbar toolbar = findViewById(R.id.toolbar_phone);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.toolbar)));
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.toolbar));

//ads
        MobileAds.initialize(this, new InitializationListener() {
            @Override
            public void onInitializationCompleted() {
                Log.d(YANDEX_MOBILE_ADS_TAG, "SDK initialized");
            }
        });
        final AdRequest adRequest = new AdRequest.Builder().build();
        mBannerAdView =  findViewById(R.id.banner_ad_view);
        mBannerAdView.setAdUnitId("R-M-1760873-1");
        mBannerAdView.setAdSize(AdSize.BANNER_320x50);
        mBannerAdView.loadAd(adRequest);


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

    private void setUpRecyclerView() throws ClassNotFoundException {
        RecyclerView recyclerView = findViewById(R.id.phone_recycler);
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
