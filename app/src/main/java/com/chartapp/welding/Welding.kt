package com.chartapp.welding

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.inputmethod.EditorInfo
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chartapp.CommonData
import com.chartapp.R
import com.chartapp.monitors.Monitor
import com.chartapp.phones.PhoneAdapter
import com.yandex.mobile.ads.banner.AdSize
import com.yandex.mobile.ads.banner.BannerAdView
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.MobileAds

class Welding : AppCompatActivity() {
    private var adapter: WeldingAdapter? = null
    private var exampleList: MutableList<CommonData>? = null
    lateinit var mBannerAdView: BannerAdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)
        fillExampleList()
        try {
            fillExampleList()
            setUpRecyclerView()
            setUpToolbar()
            ads()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }

    }

    private fun fillExampleList() {
        exampleList = ArrayList()
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.kedr, "Кедр", "Количество схем - " + 5))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.ptk, "ПТК", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.solaris, "Solaris", "Количество схем - " + 4))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.gladiator, "Гладиатор", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.kalibr, "Калибр", "Количество схем - " + 2))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.kontur, "Контур", "Количество схем - " + 2))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.linkor, "Линкор", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.empty, "Мангуст", "Количество схем - " + 3))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.neon, "Неон", "Количество схем - " + 46))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.empty, "ПДГ", "Количество схем - " + 32))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.ciklon, "Питон", "Количество схем - " + 6))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.pulsar, "Пульсар", "Количество схем - " + 2))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.resanta, "Ресанта", "Количество схем - " + 28))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.empty, "Рикон", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.svarog, "Сварог", "Количество схем - " + 20))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.empty, "Спутник", "Количество схем - " + 2))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.termit, "Термит", "Количество схем - " + 2))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.technotron, "Технотрон", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.torus, "Торус", "Количество схем - " + 2))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.feb, "ФЕБ", "Количество схем - " + 5))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.forsazh, "Форсаж", "Количество схем - " + 5))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.ciklon, "Циклон", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.aotai, "AOTAI", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.aurora, "Aurora", "Количество схем - " + 2))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.blueweld, "BlueWeld", "Количество схем - " + 4))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.bestweld, "BestWeld", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.brima, "Brima", "Количество схем - " + 2))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.cebora, "CEBORA", "Количество схем - " + 2))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.cemont, "CEMONT", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.china, "Инверторы китайских брендов", "Количество схем - " + 14))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.deca, "DECA", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.edon, "Edon", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.esab, "ESAB", "Количество схем - " + 31))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.ewm, "EWM", "Количество схем - " + 15))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.foxweld, "Foxweld", "Количество схем - " + 2))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.fronius, "Fronius", "Количество схем - " + 2))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.fubag, "Fubag", "Количество схем - " + 6))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.gys, "GYSmi", "Количество схем - " + 7))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.hitachi, "Hitachi", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.hypertherm, "HYPERTERM", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.empty, "INE", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.kemppi, "Kemppi", "Количество схем - " + 18))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.kende, "KENDE", "Количество схем - " + 4))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.lincolnelectric, "Lincoln Electric", "Количество схем - " + 7))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.migatronic, "Migatronic", "Количество схем - " + 3))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.murex, "Murex", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.nebula, "NEBULA", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.profi, "ProfHelper", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.quattro, "Quattro Elementi", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.redbo, "Redbo", "Количество схем - " + 6))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.empty, "Российские производители", "Количество схем - " + 44))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.selma, "SELMA", "Количество схем - " + 8))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.sip, "SIP", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.start, "START", "Количество схем - " + 2))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.sturm, "Sturm", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.telwin, "Telwin", "Количество схем - " + 15))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.thermal_dyn, "Thermal Dynamics", "Количество схем - " + 4))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.torros, "TORROS", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.wester, "WESTER", "Количество схем - " + 2))
    }

    @Throws(ClassNotFoundException::class)
    private fun setUpRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.phone_recycler)
        recyclerView.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        adapter = exampleList?.let { WeldingAdapter(it) }
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.example_menu, menu)
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.imeOptions = EditorInfo.IME_ACTION_DONE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                adapter!!.filter.filter(newText)
                return false
            }
        })
        return true
    }
    fun setUpToolbar(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar_phone)
        setSupportActionBar(toolbar)
        toolbar.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.toolbar)))
        window.statusBarColor = ContextCompat.getColor(this, R.color.toolbar)
    }

    private fun ads() {
        MobileAds.initialize(this) { Log.d(Monitor.YANDEX_MOBILE_ADS_TAG, "SDK initialized") }
        val adRequest = AdRequest.Builder().build()
        mBannerAdView = findViewById(R.id.banner_ad_view)
        mBannerAdView.setAdUnitId("R-M-1760873-1")
        mBannerAdView.setAdSize(AdSize.BANNER_320x50)
        mBannerAdView.loadAd(adRequest)
    }

    companion object {
        private const val YANDEX_MOBILE_ADS_TAG = "YandexMobileAds"
    }
}