package com.chartapp.power;

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

public class Power extends AppCompatActivity {
    private PowerAdapter adapter;
    private List<PowerData> exampleList;
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
        exampleList.add(new PowerData(R.drawable.atx, "ATX", "Количество схем - "+45));
        exampleList.add(new PowerData(R.drawable.cheftec, "Cheftec", "Количество схем - "+20));
        exampleList.add(new PowerData(R.drawable.colorsit, "ColorSit", "Количество схем - "+12));
        exampleList.add(new PowerData(R.drawable.coolermaster, "Cooler Master", "Количество схем - "+1));
        exampleList.add(new PowerData(R.drawable.corsair, "Corsair", "Количество схем - "+1));
        exampleList.add(new PowerData(R.drawable.cwt, "CWT", "Количество схем - "+1));
        exampleList.add(new PowerData(R.drawable.dell, "Dell", "Количество схем - "+11));
        exampleList.add(new PowerData(R.drawable.delta, "Delta Electronics", "Количество схем - "+7));
        exampleList.add(new PowerData(R.drawable.dtk, "DTK", "Количество схем - "+17));
        exampleList.add(new PowerData(R.drawable.fsp, "FSP", "Количество схем - "+15));
        exampleList.add(new PowerData(R.drawable.greentech, "Green Tech", "Количество схем - "+1));
        exampleList.add(new PowerData(R.drawable.jnc, "JNC", "Количество схем - "+5));
        exampleList.add(new PowerData(R.drawable.laptop, "Блоки питания ноутбуков", "Количество схем - "+31));
        exampleList.add(new PowerData(R.drawable.liteon, "LiteOn", "Количество схем - "+6));
        exampleList.add(new PowerData(R.drawable.maxpower, "Max Power", "Количество схем - "+2));
        exampleList.add(new PowerData(R.drawable.microlab, "Microlab", "Количество схем - "+3));
        exampleList.add(new PowerData(R.drawable.powerman, "Power Man", "Количество схем - "+5));
        exampleList.add(new PowerData(R.drawable.powermaster, "Power Master", "Количество схем - "+3));
        exampleList.add(new PowerData(R.drawable.seventeam, "Seven Team", "Количество схем - "+2));
        exampleList.add(new PowerData(R.drawable.themaltake, "Thermaltake", "Количество схем - "+1));



    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.phone_recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new PowerAdapter((ArrayList<PowerData>) exampleList);

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