package com.kborodin.mapweatherforecast.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kborodin.mapweatherforecast.MyApp
import com.kborodin.mapweatherforecast.dagger.component.MainComponent

abstract class BaseActivity: AppCompatActivity() {

    fun getMyApp():MyApp {
        return application as MyApp
    }

    fun getMainComponent(): MainComponent {
        return getMyApp().getMainComponent()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    abstract fun getLayoutId(): Int
}