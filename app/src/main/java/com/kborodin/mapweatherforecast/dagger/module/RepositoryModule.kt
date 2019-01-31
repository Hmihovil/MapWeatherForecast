package com.kborodin.mapweatherforecast.dagger.module

import com.kborodin.mapweatherforecast.repository.WeatherRepository
import com.kborodin.mapweatherforecast.repository.WeatherRepositoryInit
import com.kborodin.mapweatherforecast.service.WeatherService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides @Singleton fun provideWeatherRepository(service: WeatherService): WeatherRepository {
        return WeatherRepositoryInit(service)
    }
}