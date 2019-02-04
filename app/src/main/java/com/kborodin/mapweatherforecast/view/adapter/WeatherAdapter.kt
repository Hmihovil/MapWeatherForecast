package com.kborodin.mapweatherforecast.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.kborodin.mapweatherforecast.R
import com.kborodin.mapweatherforecast.data.model.WeatherData
import com.kborodin.mapweatherforecast.utils.getTempString
import com.kborodin.mapweatherforecast.utils.getWeatherIcon

class WeatherAdapter(private val context: Context): RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    private lateinit var weatherData: WeatherData
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_weather, parent, false))
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvCity.text = weatherData.name
        holder.tvCondition.text = weatherData.weather[0].description
        holder.tvTemp.text = String.format(getTempString(weatherData.main.temp) + "°C")
        setWeatherIcon(holder)
    }

    private fun setWeatherIcon(holder: ViewHolder) {
        if (weatherData.weather.size > 0) {
            val id = weatherData.weather[0].id
            holder.tvIcon.setImageDrawable(getWeatherIcon(context, id))
        }
    }

    fun setDataWeather(data: WeatherData) {
        weatherData = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvIcon = itemView.findViewById<AppCompatImageView>(R.id.tv_icon)!!
        val tvCity = itemView.findViewById<TextView>(R.id.tv_city)!!
        val tvCondition = itemView.findViewById<TextView>(R.id.tv_condition)!!
        val tvTemp = itemView.findViewById<TextView>(R.id.tv_temp)!!
    }
}