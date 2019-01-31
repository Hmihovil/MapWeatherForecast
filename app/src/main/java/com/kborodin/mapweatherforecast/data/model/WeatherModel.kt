package com.kborodin.mapweatherforecast.data.model

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class Clouds(val all: Int)

data class Main(
    val temp: Double, val pressure: Double, val humidity: Int, @SerializedName("temp_min") val tempMin: Double,
    @SerializedName("temp_max") val tempMax: Double, val seaLevel: Double, val grndLevel: Double
)

data class Sys(val message: Double, val country: String, val sunrise: Int, val sunset: Int)

data class Wind(val speed: Double, val deg: Double)

data class WeatherData(
    val coord: Coord,
    val weather: ArrayList<Weather>,
    val base: String,
    val main: Main,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Int,
    val sys: Sys,
    val id: Int,
    val name: String,
    val cod: Int
)
