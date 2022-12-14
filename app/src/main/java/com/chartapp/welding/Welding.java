package com.chartapp.welding;

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

import java.util.ArrayList;
import java.util.List;

public class Welding extends AppCompatActivity {
    private WeldingAdapter adapter;
    private List<WeldingData> exampleList;
    BannerAdView mBannerAdView;
    private static final String YANDEX_MOBILE_ADS_TAG = "YandexMobileAds";


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        fillExampleList();
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
    private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new WeldingData(R.drawable.kedr, "????????", "???????????????????? ???????? - "+5));
        exampleList.add(new WeldingData(R.drawable.ptk, "??????", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.solaris, "Solaris", "???????????????????? ???????? - "+4));
        exampleList.add(new WeldingData(R.drawable.gladiator, "??????????????????", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.kalibr, "????????????", "???????????????????? ???????? - "+2));
        exampleList.add(new WeldingData(R.drawable.kontur, "????????????", "???????????????????? ???????? - "+2));
        exampleList.add(new WeldingData(R.drawable.linkor, "????????????", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.empty, "??????????????", "???????????????????? ???????? - "+3));
        exampleList.add(new WeldingData(R.drawable.neon, "????????", "???????????????????? ???????? - "+46));
        exampleList.add(new WeldingData(R.drawable.empty, "??????", "???????????????????? ???????? - "+32));
        exampleList.add(new WeldingData(R.drawable.ciklon, "??????????", "???????????????????? ???????? - "+6));
        exampleList.add(new WeldingData(R.drawable.pulsar, "??????????????", "???????????????????? ???????? - "+2));
        exampleList.add(new WeldingData(R.drawable.resanta, "??????????????", "???????????????????? ???????? - "+28));
        exampleList.add(new WeldingData(R.drawable.empty, "??????????", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.svarog, "????????????", "???????????????????? ???????? - "+20));
        exampleList.add(new WeldingData(R.drawable.empty, "??????????????", "???????????????????? ???????? - "+2));
        exampleList.add(new WeldingData(R.drawable.termit, "????????????", "???????????????????? ???????? - "+2));
        exampleList.add(new WeldingData(R.drawable.technotron, "??????????????????", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.torus, "??????????", "???????????????????? ???????? - "+2));
        exampleList.add(new WeldingData(R.drawable.feb, "??????", "???????????????????? ???????? - "+5));
        exampleList.add(new WeldingData(R.drawable.forsazh, "????????????", "???????????????????? ???????? - "+5));
        exampleList.add(new WeldingData(R.drawable.ciklon, "????????????", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.aotai, "AOTAI", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.aurora, "Aurora", "???????????????????? ???????? - "+2));
        exampleList.add(new WeldingData(R.drawable.blueweld, "BlueWeld", "???????????????????? ???????? - "+4));
        exampleList.add(new WeldingData(R.drawable.bestweld, "BestWeld", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.brima, "Brima", "???????????????????? ???????? - "+2));
        exampleList.add(new WeldingData(R.drawable.cebora, "CEBORA", "???????????????????? ???????? - "+2));
        exampleList.add(new WeldingData(R.drawable.cemont, "CEMONT", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.china, "?????????????????? ?????????????????? ??????????????", "???????????????????? ???????? - "+14));
        exampleList.add(new WeldingData(R.drawable.deca, "DECA", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.edon, "Edon", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.esab, "ESAB", "???????????????????? ???????? - "+31));
        exampleList.add(new WeldingData(R.drawable.ewm, "EWM", "???????????????????? ???????? - "+15));
        exampleList.add(new WeldingData(R.drawable.foxweld, "Foxweld", "???????????????????? ???????? - "+2));
        exampleList.add(new WeldingData(R.drawable.fronius, "Fronius", "???????????????????? ???????? - "+2));
        exampleList.add(new WeldingData(R.drawable.fubag, "Fubag", "???????????????????? ???????? - "+6));
        exampleList.add(new WeldingData(R.drawable.gys, "GYSmi", "???????????????????? ???????? - "+7));
        exampleList.add(new WeldingData(R.drawable.hitachi, "Hitachi", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.hypertherm, "HYPERTERM", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.empty, "INE", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.kemppi, "Kemppi", "???????????????????? ???????? - "+18));
        exampleList.add(new WeldingData(R.drawable.kende, "KENDE", "???????????????????? ???????? - "+4));
        exampleList.add(new WeldingData(R.drawable.lincolnelectric, "Lincoln Electric", "???????????????????? ???????? - "+7));
        exampleList.add(new WeldingData(R.drawable.migatronic, "Migatronic", "???????????????????? ???????? - "+3));
        exampleList.add(new WeldingData(R.drawable.murex, "Murex", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.nebula, "NEBULA", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.profi, "ProfHelper", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.quattro, "Quattro Elementi", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.redbo, "Redbo", "???????????????????? ???????? - "+6));
        exampleList.add(new WeldingData(R.drawable.empty, "???????????????????? ??????????????????????????", "???????????????????? ???????? - "+44));
        exampleList.add(new WeldingData(R.drawable.selma, "SELMA", "???????????????????? ???????? - "+8));
        exampleList.add(new WeldingData(R.drawable.sip, "SIP", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.start, "START", "???????????????????? ???????? - "+2));
        exampleList.add(new WeldingData(R.drawable.sturm, "Sturm", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.telwin, "Telwin", "???????????????????? ???????? - "+15));
        exampleList.add(new WeldingData(R.drawable.thermal_dyn, "Thermal Dynamics", "???????????????????? ???????? - "+4));
        exampleList.add(new WeldingData(R.drawable.torros, "TORROS", "???????????????????? ???????? - "+1));
        exampleList.add(new WeldingData(R.drawable.wester, "WESTER", "???????????????????? ???????? - "+2));

    }

    private void setUpRecyclerView() throws ClassNotFoundException {
        RecyclerView recyclerView = findViewById(R.id.phone_recycler);
      recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new WeldingAdapter(exampleList);

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