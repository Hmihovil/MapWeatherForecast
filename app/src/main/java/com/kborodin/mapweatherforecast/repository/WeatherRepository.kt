package com.kborodin.mapweatherforecast.repository

import com.kborodin.mapweatherforecast.data.model.ForecastData
import com.kborodin.mapweatherforecast.data.model.WeatherData
import io.reactivex.Observable

interface WeatherRepository {
    fun getWeatherByCity(cityName: String, units: String): Observable<WeatherData>

    fun getForecastByCity(cityName: String, units: String): Observable<ForecastData>

    fun getWeatherByLocation(lat: String, lon: String, units: String): Observable<WeatherData>

    fun getForecastByLocation(lat: String, lon: String, units: String): Observable<ForecastData>
}