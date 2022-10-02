package com.chartapp.monitors

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.yandex.mobile.ads.banner.BannerAdView
import android.annotation.SuppressLint
import android.os.Bundle
import com.chartapp.R
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Menu
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.SearchView
import androidx.appcompat.widget.Toolbar
import com.chartapp.Adapter
import com.chartapp.Data
import com.chartapp.phones.Phone_catalog
import com.yandex.mobile.ads.banner.AdSize
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.MobileAds
import java.lang.Exception
import java.util.ArrayList

class Monitor_catalog : AppCompatActivity() {
    var data: String? = null
    var myDB: Monitor_helper? = null
    var list: ArrayList<Data>? = null
    var customAdapter: Adapter? = null
    var recyclerView: RecyclerView? = null
   lateinit var mBannerAdView: BannerAdView
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val extras = intent.extras
        data = extras!!.getString("testNameData")
        setContentView(R.layout.activity_recycler)

        recyclerView = findViewById(R.id.recyclerView)
        myDB = Monitor_helper(this)
        Monitor_helper.tab_name = data
        title = data
        list = ArrayList()
        showData(recyclerView)
        ads()
        setUpToolbar()
    }

    fun showData(view: View?) {
        try {
            list = myDB!!.allData
            customAdapter = list?.let { Adapter(it) }
            recyclerView!!.hasFixedSize()
            recyclerView!!.layoutManager = LinearLayoutManager(this)
            recyclerView!!.adapter = customAdapter
        } catch (e: Exception) {
            Toast.makeText(this, "show_data" + e.message, Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
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
                customAdapter!!.filter.filter(newText)
                return false
            }
        })
        return true
    }
    fun ads(){
        MobileAds.initialize(this) { Log.d(Phone_catalog.YANDEX_MOBILE_ADS_TAG, "SDK initialized") }
        val adRequest = AdRequest.Builder().build()
        mBannerAdView = findViewById(R.id.banner_ad_view)
        mBannerAdView.setAdUnitId("R-M-1760873-1")
        mBannerAdView.setAdSize(AdSize.BANNER_320x50)
        mBannerAdView.loadAd(adRequest)
    }
    fun setUpToolbar(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar_phone)
        setSupportActionBar(toolbar)
        toolbar.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.toolbar)))
        window.statusBarColor = ContextCompat.getColor(this, R.color.toolbar)
    }

    companion object {
        private const val YANDEX_MOBILE_ADS_TAG = "YandexMobileAds"
    }
}