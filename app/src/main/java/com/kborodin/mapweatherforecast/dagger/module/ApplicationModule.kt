package com.kborodin.mapweatherforecast.dagger.module

import android.app.Application
import com.kborodin.mapweatherforecast.MyApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: Application) {
    @Provides
    @Singleton
    fun provideApplication(): Application {
        return app
    }
}