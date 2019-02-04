package com.kborodin.mapweatherforecast.service

import com.kborodin.mapweatherforecast.data.model.ForecastData
import com.kborodin.mapweatherforecast.data.model.WeatherData
import com.kborodin.mapweatherforecast.utils.Constants
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET(Constants.API_WEATHER + Constants.API_APP_ID)
    fun getWeatherByCity(
        @Query("q") cityName: String, @Query("units") units: String
    ): Observable<WeatherData>

    @GET(Constants.API_FORECAST + Constants.API_APP_ID)
    fun getForecastByCity(
        @Query("q") cityName: String, @Query("units") units: String
    ): Observable<ForecastData>

    @GET(Constants.API_WEATHER + Constants.API_APP_ID + Constants.LOCALE)
    fun getWeatherByLocation(
        @Query("lat") lat: String, @Query("lon") lon: String, @Query("units") units: String
    ): Observable<WeatherData>

    @GET(Constants.API_FORECAST + Constants.API_APP_ID + Constants.LOCALE)
    fun getForecastByLocation(
        @Query("lat") lat: String, @Query("lon") lon: String, @Query("units") units: String
    ): Observable<ForecastData>
}