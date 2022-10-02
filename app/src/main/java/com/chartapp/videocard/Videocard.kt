package com.chartapp.videocard

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

class Videocard : AppCompatActivity() {
    private var adapter: VideocardAdapter? = null
    private var exampleList: MutableList<CommonData>? = null
    lateinit var mBannerAdView: BannerAdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)
        try {
            fillExampleList()
            setUpRecyclerView()
            setUpToolbar()
            ads()
        } catch (e: IOException) {
            e.printStackTrace()
        }



    }

    @Throws(IOException::class)
    private fun fillExampleList() {
        exampleList = ArrayList()
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.amd, "AMD", "Количество схем - " + 6))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.asus, "Asus", "Количество схем - " + 187))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.colorful, "Colorful", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.galaxy, "Galaxy", "Количество схем - " + 7))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.gigabyte, "Gigabyte", "Количество схем - " + 55))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.msi, "MSI", "Количество схем - " + 228))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.nvidia, "Nvidia", "Количество схем - " + 6))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.palit, "Palit", "Количество схем - " + 1))
    }

    private fun setUpRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.phone_recycler)
        recyclerView.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        adapter = (exampleList as ArrayList<CommonData>?)?.let { VideocardAdapter(it) }
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