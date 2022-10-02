package com.chartapp.laptop

import android.annotation.SuppressLint
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
import com.yandex.mobile.ads.banner.AdSize
import com.yandex.mobile.ads.banner.BannerAdView
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.MobileAds
import java.io.IOException

class Laptop : AppCompatActivity() {
    private var adapter: LaptopAdapter? = null
    private var exampleList: MutableList<CommonData>? = null
    lateinit var mBannerAdView: BannerAdView
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)
        try {
            fillExampleList()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        try {
            setUpRecyclerView()
            setUpToolbar()
            ads()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }

    }

    @Throws(IOException::class)
    private fun fillExampleList() {
        exampleList = ArrayList()
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.compal, "Compal", "Количество схем - " + 6))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.acer, "Acer", "Количество схем - " + 419))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.asus, "Asus", "Количество схем - " + 63))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.apple, "Apple", "Количество схем - " + 3))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.aristo, "Aristo", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.benq, "Benq", "Количество схем - " + 8))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.clevo, "Clevo", "Количество схем - " + 95))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.compaq, "Compaq", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.dns, "DNS", "Количество схем - " + 10))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.fujitsu, "Fujitsu-Siemens", "Количество схем - " + 15))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.gateway, "Gateway", "Количество схем - " + 21))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.gericom, "Gericom", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.dell, "Dell", "Количество схем - " + 106))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.hp, "HP", "Количество схем - " + 104))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.lenovo, "Lenovo", "Количество схем - " + 139))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.lg, "LG", "Количество схем - " + 6))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.packard_bell, "Packard Bell", "Количество схем - " + 43))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.samsung, "Samsung", "Количество схем - " + 66))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.roverbook, "Roverbook", "Количество схем - " + 9))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.sony, "Sony", "Количество схем - " + 53))
    }

    @Throws(ClassNotFoundException::class)
    private fun setUpRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.phone_recycler)
        recyclerView.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        adapter = (exampleList as ArrayList<CommonData>?)?.let { LaptopAdapter(it) }
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