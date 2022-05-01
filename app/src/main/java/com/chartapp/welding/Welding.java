package com.chartapp.welding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import com.chartapp.R;
import com.chartapp.welding.WeldingAdapter;


import java.util.ArrayList;
import java.util.List;

public class Welding extends AppCompatActivity {
    private WeldingAdapter adapter;
    private List<WeldingData> exampleList;


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



    }
    private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new WeldingData(R.drawable.kedr, "Кедр", "Количество схем - "+5));
        exampleList.add(new WeldingData(R.drawable.ptk, "ПТК", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.solaris, "Solaris", "Количество схем - "+4));
        exampleList.add(new WeldingData(R.drawable.gladiator, "Гладиатор", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.kalibr, "Калибр", "Количество схем - "+2));
        exampleList.add(new WeldingData(R.drawable.kontur, "Контур", "Количество схем - "+2));
        exampleList.add(new WeldingData(R.drawable.linkor, "Линкор", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.empty, "Мангуст", "Количество схем - "+3));
        exampleList.add(new WeldingData(R.drawable.neon, "Неон", "Количество схем - "+46));
        exampleList.add(new WeldingData(R.drawable.empty, "ПДГ", "Количество схем - "+32));
        exampleList.add(new WeldingData(R.drawable.ciklon, "Питон", "Количество схем - "+6));
        exampleList.add(new WeldingData(R.drawable.pulsar, "Пульсар", "Количество схем - "+2));
        exampleList.add(new WeldingData(R.drawable.resanta, "Ресанта", "Количество схем - "+28));
        exampleList.add(new WeldingData(R.drawable.empty, "Рикон", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.svarog, "Сварог", "Количество схем - "+20));
        exampleList.add(new WeldingData(R.drawable.empty, "Спутник", "Количество схем - "+2));
        exampleList.add(new WeldingData(R.drawable.termit, "Термит", "Количество схем - "+2));
        exampleList.add(new WeldingData(R.drawable.technotron, "Технотрон", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.torus, "Торус", "Количество схем - "+2));
        exampleList.add(new WeldingData(R.drawable.feb, "ФЕБ", "Количество схем - "+5));
        exampleList.add(new WeldingData(R.drawable.forsazh, "Форсаж", "Количество схем - "+5));
        exampleList.add(new WeldingData(R.drawable.ciklon, "Циклон", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.aotai, "AOTAI", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.aurora, "Aurora", "Количество схем - "+2));
        exampleList.add(new WeldingData(R.drawable.blueweld, "BlueWeld", "Количество схем - "+4));
        exampleList.add(new WeldingData(R.drawable.bestweld, "BestWeld", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.brima, "Brima", "Количество схем - "+2));
        exampleList.add(new WeldingData(R.drawable.cebora, "CEBORA", "Количество схем - "+2));
        exampleList.add(new WeldingData(R.drawable.cemont, "CEMONT", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.china, "Инверторы китайских брендов", "Количество схем - "+14));
        exampleList.add(new WeldingData(R.drawable.deca, "DECA", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.edon, "Edon", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.esab, "ESAB", "Количество схем - "+31));
        exampleList.add(new WeldingData(R.drawable.ewm, "EWM", "Количество схем - "+15));
        exampleList.add(new WeldingData(R.drawable.foxweld, "Foxweld", "Количество схем - "+2));
        exampleList.add(new WeldingData(R.drawable.fronius, "Fronius", "Количество схем - "+2));
        exampleList.add(new WeldingData(R.drawable.fubag, "Fubag", "Количество схем - "+6));
        exampleList.add(new WeldingData(R.drawable.gys, "GYSmi", "Количество схем - "+7));
        exampleList.add(new WeldingData(R.drawable.hitachi, "Hitachi", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.hypertherm, "HYPERTERM", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.empty, "INE", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.kemppi, "Kemppi", "Количество схем - "+18));
        exampleList.add(new WeldingData(R.drawable.kende, "KENDE", "Количество схем - "+4));
        exampleList.add(new WeldingData(R.drawable.lincolnelectric, "Lincoln Electric", "Количество схем - "+7));
        exampleList.add(new WeldingData(R.drawable.migatronic, "Migatronic", "Количество схем - "+3));
        exampleList.add(new WeldingData(R.drawable.murex, "Murex", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.nebula, "NEBULA", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.profi, "ProfHelper", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.quattro, "Quattro Elementi", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.redbo, "Redbo", "Количество схем - "+6));
        exampleList.add(new WeldingData(R.drawable.empty, "Российские производители", "Количество схем - "+44));
        exampleList.add(new WeldingData(R.drawable.selma, "SELMA", "Количество схем - "+8));
        exampleList.add(new WeldingData(R.drawable.sip, "SIP", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.start, "START", "Количество схем - "+2));
        exampleList.add(new WeldingData(R.drawable.sturm, "Sturm", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.telwin, "Telwin", "Количество схем - "+15));
        exampleList.add(new WeldingData(R.drawable.thermal_dyn, "Thermal Dynamics", "Количество схем - "+4));
        exampleList.add(new WeldingData(R.drawable.torros, "TORROS", "Количество схем - "+1));
        exampleList.add(new WeldingData(R.drawable.wester, "WESTER", "Количество схем - "+2));

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