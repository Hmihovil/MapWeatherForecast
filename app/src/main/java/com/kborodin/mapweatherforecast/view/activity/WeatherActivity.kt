package com.kborodin.mapweatherforecast.view.activity

import android.os.Bundle
import com.kborodin.mapweatherforecast.R

class WeatherActivity: BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getMainComponent().inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_weather
    }
}
