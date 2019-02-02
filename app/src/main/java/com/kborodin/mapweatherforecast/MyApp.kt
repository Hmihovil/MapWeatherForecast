package com.kborodin.mapweatherforecast

import android.app.Application
import android.content.Context
import com.kborodin.mapweatherforecast.dagger.component.DaggerMainComponent
import com.kborodin.mapweatherforecast.dagger.component.MainComponent
import com.kborodin.mapweatherforecast.dagger.module.ApplicationModule


 class MyApp : Application() {

    private lateinit var context: Context
    private lateinit var component: MainComponent

    override fun onCreate() {
        super.onCreate()

        initDagger()
        context = this
    }

    private fun initDagger() {
        component = DaggerMainComponent.builder().applicationModule(ApplicationModule(this)).build()
    }

    fun getContext(): Context {
        return context
    }


    fun getMainComponent(): MainComponent {
        return component
    }

}