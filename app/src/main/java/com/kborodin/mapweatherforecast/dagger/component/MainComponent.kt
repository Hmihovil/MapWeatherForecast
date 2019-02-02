package com.kborodin.mapweatherforecast.dagger.component

import com.kborodin.mapweatherforecast.dagger.module.ApplicationModule
import com.kborodin.mapweatherforecast.dagger.module.NetworkModule
import com.kborodin.mapweatherforecast.dagger.module.RepositoryModule
import com.kborodin.mapweatherforecast.dagger.module.ServiceModule
import com.kborodin.mapweatherforecast.view.activity.WeatherActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class, ServiceModule::class, RepositoryModule::class])
interface MainComponent {

    fun inject(weatherActivity: WeatherActivity)

}
