package com.chartapp.phones;

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


public class Phone extends AppCompatActivity  {

    private PhoneAdapter adapter;
    private List<PhoneData> exampleList;
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
        exampleList.add(new PhoneData(R.drawable.xiaomi, "Xiaomi", "???????????????????? ???????? - "+55));
        exampleList.add(new PhoneData(R.drawable.apple, "Apple", "???????????????????? ???????? - "+26));
        exampleList.add(new PhoneData(R.drawable.asus, "Asus", "???????????????????? ???????? - "+21));
        exampleList.add(new PhoneData(R.drawable.samsung, "Samsung", "???????????????????? ???????? - "+88));
        exampleList.add(new PhoneData(R.drawable.huawei, "Huawei", "???????????????????? ???????? - "+55));
        exampleList.add(new PhoneData(R.drawable.blackberry, "Blackberry", "???????????????????? ???????? - "+6));
        exampleList.add(new PhoneData(R.drawable.meizu, "Meizu", "???????????????????? ???????? - "+8));
        exampleList.add(new PhoneData(R.drawable.oppo, "OPPO", "???????????????????? ???????? - "+20));
        exampleList.add(new PhoneData(R.drawable.nokia, "Nokia", "???????????????????? ???????? - "+73));
        exampleList.add(new PhoneData(R.drawable.lg, "LG", "???????????????????? ???????? - "+5));
        exampleList.add(new PhoneData(R.drawable.lenovo, "Lenovo", "???????????????????? ???????? - "+86));
        exampleList.add(new PhoneData(R.drawable.fly, "Fly", "???????????????????? ???????? - "+41));
        exampleList.add(new PhoneData(R.drawable.motorola, "Motorola", "???????????????????? ???????? - "+50));
        exampleList.add(new PhoneData(R.drawable.panasonic, "Panasonic", "???????????????????? ???????? - "+19));
        exampleList.add(new PhoneData(R.drawable.pantech, "Pantech", "???????????????????? ???????? - "+15));
        exampleList.add(new PhoneData(R.drawable.sharp, "Sharp", "???????????????????? ???????? - "+9));
        exampleList.add(new PhoneData(R.drawable.siemens, "Siemens", "???????????????????? ???????? - "+42));
        exampleList.add(new PhoneData(R.drawable.sony_eric, "Sony Ericsson", "???????????????????? ???????? - "+15));
        exampleList.add(new PhoneData(R.drawable.sony, "Sony", "???????????????????? ???????? - "+2));
        exampleList.add(new PhoneData(R.drawable.voxtel, "Voxtel", "???????????????????? ???????? - "+4));
        exampleList.add(new PhoneData(R.drawable.wexler, "Wexler", "???????????????????? ???????? - "+4));

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

