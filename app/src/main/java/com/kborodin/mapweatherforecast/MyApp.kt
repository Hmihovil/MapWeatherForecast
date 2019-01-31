package com.kborodin.mapweatherforecast

import android.app.Application
import android.content.Context
import com.kborodin.mapweatherforecast.dagger.component.MainComponent
import com.kborodin.mapweatherforecast.dagger.module.ApplicationModule
import dagger.internal.DaggerCollections

class MyApp: Application() {

    private lateinit var context: Context
    private lateinit var component: MainComponent
    override fun onCreate() {
        super.onCreate()

        context = this
    }

    fun initDager() {
    }

    fun getContext(): Context {
        return context
    }


    fun getMainComponent(): MainComponent {
        return component
    }

}