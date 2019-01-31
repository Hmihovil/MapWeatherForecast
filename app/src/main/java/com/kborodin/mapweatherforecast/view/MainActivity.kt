package com.kborodin.mapweatherforecast.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kborodin.mapweatherforecast.MyApp
import com.kborodin.mapweatherforecast.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val instance = application as MyApp
        instance.getMainComponent().inject(this)


    }
}
