package com.kborodin.mapweatherforecast.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kborodin.mapweatherforecast.R
import com.kborodin.mapweatherforecast.data.model.ForecastData

class ForecastAdapter(private val context: Context) : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    private lateinit var forecastData: ForecastData

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_weather, parent, false))
    }

    override fun getItemCount(): Int {
        return forecastData.list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    fun setDataForecast(data: ForecastData) {
        forecastData = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvIcon = itemView.findViewById<TextView>(R.id.tv_icon)
        val tvWeekday = itemView.findViewById<TextView>(R.id.tv_weekday)
        val tvCondition = itemView.findViewById<TextView>(R.id.tv_condition)
        val tvTempMin = itemView.findViewById<TextView>(R.id.tv_temp_min)
        val tvTempMax = itemView.findViewById<TextView>(R.id.tv_temp_max)
    }

}