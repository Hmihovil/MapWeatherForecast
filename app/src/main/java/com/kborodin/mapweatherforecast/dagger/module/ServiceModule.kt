package com.kborodin.mapweatherforecast.dagger.module

import com.kborodin.mapweatherforecast.service.WeatherService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {
    @Provides @Singleton fun provideWeatherService (retrofit: Retrofit): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }
}