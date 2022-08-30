package com.chartapp.videocard;

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

import com.chartapp.CommonData;
import com.chartapp.R;
import com.yandex.mobile.ads.banner.AdSize;
import com.yandex.mobile.ads.banner.BannerAdView;
import com.yandex.mobile.ads.common.AdRequest;
import com.yandex.mobile.ads.common.InitializationListener;
import com.yandex.mobile.ads.common.MobileAds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Videocard extends AppCompatActivity {
    private VideocardAdapter adapter;
    private List<CommonData> exampleList;

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
        setUpRecyclerView();
        Toolbar toolbar = findViewById(R.id.toolbar_phone);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.toolbar)));
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.toolbar));

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
        exampleList.add(new CommonData(R.drawable.amd, "AMD", "Количество схем - "+6));
        exampleList.add(new CommonData(R.drawable.asus, "Asus", "Количество схем - "+187));
        exampleList.add(new CommonData(R.drawable.colorful, "Colorful", "Количество схем - "+1));
        exampleList.add(new CommonData(R.drawable.galaxy, "Galaxy", "Количество схем - "+7));
        exampleList.add(new CommonData(R.drawable.gigabyte, "Gigabyte", "Количество схем - "+55));
        exampleList.add(new CommonData(R.drawable.msi, "MSI", "Количество схем - "+228));
        exampleList.add(new CommonData(R.drawable.nvidia, "Nvidia", "Количество схем - "+6));
        exampleList.add(new CommonData(R.drawable.palit, "Palit", "Количество схем - "+1));


    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.phone_recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new VideocardAdapter((ArrayList<CommonData>) exampleList);

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