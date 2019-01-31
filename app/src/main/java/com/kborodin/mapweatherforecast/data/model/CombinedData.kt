package com.kborodin.mapweatherforecast.data.model

data class CombinedData(val weatherData: WeatherData, val forecastData: ForecastData)

data class Coord(val lat: Double, val lon: Double)

data class Weather(val id: Int, val main: String, val description: String, val icon: String)
