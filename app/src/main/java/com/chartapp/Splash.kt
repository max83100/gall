package com.chartapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chartapp.R
import android.content.Intent
import com.chartapp.bottom.Bottom

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_AppCompat_DayNight_NoActionBar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logoTimer: Thread = object : Thread() {
            override fun run() {
                try {
                    var logoTimer = 0
                    while (logoTimer < 1500) {
                        sleep(100)
                        logoTimer = logoTimer + 100
                    }
                    startActivity(Intent(applicationContext, Bottom::class.java))
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    finish()
                }
            }
        }
        logoTimer.start()
    }
}