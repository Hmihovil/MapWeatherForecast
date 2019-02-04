package com.kborodin.mapweatherforecast.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.kborodin.mapweatherforecast.R
import com.kborodin.mapweatherforecast.data.model.ForecastData
import com.kborodin.mapweatherforecast.data.model.List
import com.kborodin.mapweatherforecast.utils.formatListOfDays
import com.kborodin.mapweatherforecast.utils.getTempString
import com.kborodin.mapweatherforecast.utils.getWeatherIcon
import com.kborodin.mapweatherforecast.utils.getWeekDay


class ForecastAdapter(private val context: Context) : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    private lateinit var forecastData: ForecastData
    private lateinit var listOfDays: ArrayList<List>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_forecast, parent, false))
    }

    override fun getItemCount(): Int {
        return listOfDays.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (forecastData.list.isNotEmpty()) {
            val forecastItem = listOfDays[position]
            holder.tvIcon.setImageDrawable(getWeatherIcon(context, forecastItem.weather[0].id))
            holder.tvWeekday.text = getWeekDay(forecastItem.dt)
            holder.tvCondition.text = forecastItem.weather[0].description
            holder.tvTemp.text = String.format(getTempString(forecastItem.main.temp) + "°C")
        }
    }

    fun setDataForecast(data: ForecastData) {
        forecastData = data
        listOfDays = formatListOfDays(forecastData.list)
        notifyDataSetChanged()
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
         val tvIcon: AppCompatImageView = v.findViewById(R.id.tv_icon) as AppCompatImageView
         val tvWeekday: TextView = v.findViewById(R.id.tv_weekday) as TextView
         val tvCondition: TextView = v.findViewById(R.id.tv_condition) as TextView
         val tvTemp: TextView = v.findViewById(R.id.tvTemp) as TextView
    }

}