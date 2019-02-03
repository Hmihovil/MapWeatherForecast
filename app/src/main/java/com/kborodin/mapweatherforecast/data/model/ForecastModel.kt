package com.kborodin.mapweatherforecast.data.model

import java.util.ArrayList

data class City(val id: Int, val name: String, val coord: Coord, val county: String, val population: Int)

data class ForecastData(val city: City, val cod: String, val message: Double, val cnt: Int, val list: ArrayList<List>)

data class List(
    val dt: Int,
    val temp: Temp,
    val pressure: Double,
    val humidity: Int,
    val weather: ArrayList<Weather>,
    val speed: Double,
    val deg: Int,
    val clouds: Clouds,
    val rain: Double
)

data class Temp(val day: Double, val min: Double, val max: Double, val night: Double, val eve: Double, val morn: Double)




