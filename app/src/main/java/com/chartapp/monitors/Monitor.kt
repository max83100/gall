package com.chartapp.monitors

import androidx.appcompat.app.AppCompatActivity
import com.chartapp.CommonData
import com.yandex.mobile.ads.banner.BannerAdView
import android.os.Bundle
import com.chartapp.R
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Menu
import androidx.core.content.ContextCompat
import kotlin.Throws
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.inputmethod.EditorInfo
import android.widget.SearchView
import androidx.appcompat.widget.Toolbar
import com.yandex.mobile.ads.banner.AdSize
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.MobileAds
import java.io.IOException
import java.util.ArrayList

class Monitor : AppCompatActivity() {
    private var adapter: Monitor_adapter? = null
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
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.acer, "Acer", "Количество схем - " + 76))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.aoc, "AOC", "Количество схем - " + 22))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.belinea, "Belinea", "Количество схем - " + 6))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.benq, "Benq", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.compaq, "Compaq", "Количество схем - " + 1))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.ctx, "CTX", "Количество схем - " + 6))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.daewoo, "Daewoo", "Количество схем - " + 10))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.dell, "Dell", "Количество схем - " + 5))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.hansol, "Hansol", "Количество схем - " + 2))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.hyndai, "Hyndai", "Количество схем - " + 4))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.iiyama, "Iiyama", "Количество схем - " + 4))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.lg, "LG", "Количество схем - " + 62))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.mag, "Mag", "Количество схем - " + 4))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.philips, "Philips", "Количество схем - " + 2))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.samsung, "Samsung", "Количество схем - " + 13))
    }

    private fun setUpRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.phone_recycler)
        recyclerView.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        adapter = (exampleList as ArrayList<CommonData>?)?.let { Monitor_adapter(it) }
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
        MobileAds.initialize(this) { Log.d(YANDEX_MOBILE_ADS_TAG, "SDK initialized") }
        val adRequest = AdRequest.Builder().build()
        mBannerAdView = findViewById(R.id.banner_ad_view)
        mBannerAdView.setAdUnitId("R-M-1760873-1")
        mBannerAdView.setAdSize(AdSize.BANNER_320x50)
        mBannerAdView.loadAd(adRequest)
    }

    companion object {
        const val YANDEX_MOBILE_ADS_TAG = "YandexMobileAds"
    }
}