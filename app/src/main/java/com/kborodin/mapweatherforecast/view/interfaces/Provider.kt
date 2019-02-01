package com.kborodin.mapweatherforecast.view.interfaces

interface Provider {

    fun getDataByCity(cityName: String, unit: String)

    fun getDataByLocation(lat: String, lon: String, unit: String)

    fun unsubscribe()
}