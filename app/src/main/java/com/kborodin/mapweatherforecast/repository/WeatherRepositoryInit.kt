package com.kborodin.mapweatherforecast.repository

import com.kborodin.mapweatherforecast.data.model.ForecastData
import com.kborodin.mapweatherforecast.data.model.WeatherData
import com.kborodin.mapweatherforecast.service.WeatherService
import io.reactivex.Observable

class WeatherRepositoryInit(private val weatherService: WeatherService) : WeatherRepository {
    override fun getWeatherByCity(cityName: String, units: String): Observable<WeatherData> {
        return weatherService.getWeatherByCity(cityName, units)
    }

    override fun getForecastByCity(cityName: String, units: String): Observable<ForecastData> {
        return weatherService.getForecastByCity(cityName, units)
    }

    override fun getWeatherByLocation(lat: String, lon: String, units: String): Observable<WeatherData> {
        return weatherService.getWeatherByLocation(lat, lon, units)
    }

    override fun getForecastByLocation(lat: String, lon: String, units: String): Observable<ForecastData> {
        return weatherService.getForecastByLocation(lat, lon, units)
    }
}