package com.kborodin.mapweatherforecast.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.kborodin.mapweatherforecast.R
import com.kborodin.mapweatherforecast.data.model.List
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

fun getWeatherIcon(context: Context, weatherId: Int): Drawable {

        var iconDrawable = ContextCompat.getDrawable(context, R.drawable.ic_warning_sign)

        when {
            weatherId < 300 -> iconDrawable = ContextCompat.getDrawable(context, R.drawable.ic_036_storm_4)
            weatherId < 500 -> iconDrawable = ContextCompat.getDrawable(context, R.drawable.ic_003_rainy)
            weatherId < 600 -> iconDrawable = ContextCompat.getDrawable(context, R.drawable.ic_004_rainy_1)
            weatherId < 700 -> iconDrawable = ContextCompat.getDrawable(context, R.drawable.ic_006_snowy)
            weatherId < 800 -> iconDrawable = ContextCompat.getDrawable(context, R.drawable.ic_017_foog)
            weatherId == 800 -> iconDrawable = ContextCompat.getDrawable(context, R.drawable.ic_039_sun)
            weatherId > 800 -> iconDrawable = ContextCompat.getDrawable(context, R.drawable.ic_001_cloud)
        }
        return iconDrawable!!
    }

fun getWeekDay(timestamp: Int): String {

    val c = Calendar.getInstance()
    c.timeInMillis = timestamp * 1000L
    val timeZone = TimeZone.getDefault()
    c.add(Calendar.MILLISECOND, timeZone.getOffset(c.timeInMillis))

    val dateFormat = SimpleDateFormat("EEEE", Locale.getDefault())
    return dateFormat.format(c.time)
}

fun getTempString(tempDouble: Double): String{
        val tempInt = Math.round(tempDouble).toInt()
        return tempInt.toString()
}

fun formatListOfDays(listOfDays: ArrayList<List>): ArrayList<List> {
    val tempArray = ArrayList<List>()
    val resultArray = ArrayList<List>()
    tempArray.addAll(listOfDays)
    var tempDay = ""
    for (day in tempArray) {
        if(tempDay != getWeekDay(day.dt)) {
            tempDay = getWeekDay(day.dt)
            resultArray.add(day)
        }
    }
    return resultArray
}