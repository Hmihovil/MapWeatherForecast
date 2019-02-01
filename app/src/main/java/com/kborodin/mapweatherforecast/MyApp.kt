package com.kborodin.mapweatherforecast

import android.app.Application
import android.content.Context
import com.kborodin.mapweatherforecast.dagger.component.DaggerMainComponent
import com.kborodin.mapweatherforecast.dagger.component.MainComponent
import com.kborodin.mapweatherforecast.dagger.module.ApplicationModule
import com.kborodin.mapweatherforecast.dagger.module.NetworkModule
import com.kborodin.mapweatherforecast.data.model.Main
import dagger.android.DaggerActivity_MembersInjector
import dagger.android.DaggerApplication
import dagger.internal.DaggerCollections

open class MyApp : Application() {

    private lateinit var context: Context
    private lateinit var component: MainComponent
    override fun onCreate() {
        super.onCreate()

        initDagger()
        context = this
    }

    private fun initDagger() {
        component = DaggerMainComponent.builder()
            .build()
    }

    fun getContext(): Context {
        return context
    }


    fun getMainComponent(): MainComponent {
        return component
    }

}