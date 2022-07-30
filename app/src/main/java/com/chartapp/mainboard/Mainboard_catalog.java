package com.chartapp.mainboard;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chartapp.Adapter;
import com.chartapp.Data;
import com.chartapp.R;
import com.yandex.mobile.ads.banner.AdSize;
import com.yandex.mobile.ads.banner.BannerAdView;
import com.yandex.mobile.ads.common.AdRequest;
import com.yandex.mobile.ads.common.InitializationListener;
import com.yandex.mobile.ads.common.MobileAds;

import java.util.ArrayList;

public class Mainboard_catalog extends AppCompatActivity {
    String data;
    Mainboard_helper myDB;
    ArrayList<Data> list;
    Adapter customAdapter;
    RecyclerView recyclerView;
    BannerAdView mBannerAdView;
    private static final String YANDEX_MOBILE_ADS_TAG = "YandexMobileAds";


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        data = extras.getString("testNameData");
        setContentView(R.layout.activity_xiaomi_catalog);
        recyclerView = findViewById(R.id.xiaomiView);
        myDB = new Mainboard_helper(this);
        Mainboard_helper.tab_name = data;
        setTitle(data);
        list = new ArrayList<>();
        showData(recyclerView);
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