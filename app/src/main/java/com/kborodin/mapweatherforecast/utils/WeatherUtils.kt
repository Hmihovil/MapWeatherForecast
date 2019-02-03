package com.kborodin.mapweatherforecast.utils

import android.content.Context
import com.kborodin.mapweatherforecast.R

    fun getWeatherIcon(context: Context, weatherId: Int): String {

        val id = weatherId / 100
        var iconText = ""

        if (id == 8) {
            iconText = context.getString(R.string.weather_sunny)
        } else {
            when (id) {
                2 -> iconText = context.getString(R.string.weather_thunder)
                3 -> iconText = context.getString(R.string.weather_drizzle)
                5 -> iconText = context.getString(R.string.weather_rainy)
                6 -> iconText = context.getString(R.string.weather_snowy)
                7 -> iconText = context.getString(R.string.weather_foggy)
            }
        }
        return iconText
    }
