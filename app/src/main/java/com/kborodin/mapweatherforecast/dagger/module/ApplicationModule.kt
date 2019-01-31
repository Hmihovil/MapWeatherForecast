package com.kborodin.mapweatherforecast.dagger.module

import com.kborodin.mapweatherforecast.MyApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: MyApp) {
    @Provides
    @Singleton
    fun provideApplication(): MyApp {
        return this.app
    }
}