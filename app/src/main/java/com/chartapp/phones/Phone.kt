package com.chartapp.phones

import androidx.appcompat.app.AppCompatActivity
import com.chartapp.phones.PhoneAdapter
import com.chartapp.CommonData
import com.yandex.mobile.ads.banner.BannerAdView
import android.annotation.SuppressLint
import android.os.Bundle
import com.chartapp.R
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Menu
import androidx.core.content.ContextCompat
import com.yandex.mobile.ads.common.InitializationListener
import kotlin.Throws
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.MenuInflater
import android.view.inputmethod.EditorInfo
import android.widget.SearchView
import androidx.appcompat.widget.Toolbar
import com.yandex.mobile.ads.banner.AdSize
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.MobileAds
import java.io.IOException
import java.util.ArrayList

class Phone : AppCompatActivity() {
    private var adapter: PhoneAdapter? = null
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
        setUpRecyclerView()
        val toolbar = findViewById<Toolbar>(R.id.toolbar_phone)
        setSupportActionBar(toolbar)
        toolbar.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.toolbar)))
        window.statusBarColor = ContextCompat.getColor(this, R.color.toolbar)

//ads
        MobileAds.initialize(this) { Log.d(YANDEX_MOBILE_ADS_TAG, "SDK initialized") }
        val adRequest = AdRequest.Builder().build()
        mBannerAdView = findViewById(R.id.banner_ad_view)
        mBannerAdView.setAdUnitId("R-M-1760873-1")
        mBannerAdView.setAdSize(AdSize.BANNER_320x50)
        mBannerAdView.loadAd(adRequest)
    }

    @Throws(IOException::class)
    private fun fillExampleList() {
        exampleList = ArrayList()
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.xiaomi, "Xiaomi", "Количество схем - " + 55))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.apple, "Apple", "Количество схем - " + 26))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.asus, "Asus", "Количество схем - " + 21))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.samsung, "Samsung", "Количество схем - " + 88))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.huawei, "Huawei", "Количество схем - " + 55))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.blackberry, "Blackberry", "Количество схем - " + 6))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.meizu, "Meizu", "Количество схем - " + 8))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.oppo, "OPPO", "Количество схем - " + 20))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.nokia, "Nokia", "Количество схем - " + 73))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.lg, "LG", "Количество схем - " + 61))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.lenovo, "Lenovo", "Количество схем - " + 86))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.fly, "Fly", "Количество схем - " + 41))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.motorola, "Motorola", "Количество схем - " + 50))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.panasonic, "Panasonic", "Количество схем - " + 19))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.pantech, "Pantech", "Количество схем - " + 15))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.sharp, "Sharp", "Количество схем - " + 9))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.siemens, "Siemens", "Количество схем - " + 42))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.sony_eric, "Sony Ericsson", "Количество схем - " + 15))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.sony, "Sony", "Количество схем - " + 2))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.voxtel, "Voxtel", "Количество схем - " + 4))
        (exampleList as ArrayList<CommonData>).add(CommonData(R.drawable.wexler, "Wexler", "Количество схем - " + 4))
    }

    private fun setUpRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.phone_recycler)
        recyclerView.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        adapter = exampleList?.let { PhoneAdapter(it) }
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

    companion object {
        private const val YANDEX_MOBILE_ADS_TAG = "YandexMobileAds"
    }
}