package com.kborodin.mapweatherforecast.view.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.model.LatLng
import com.kborodin.mapweatherforecast.MyApp
import com.kborodin.mapweatherforecast.R
import com.kborodin.mapweatherforecast.data.model.CombinedData
import com.kborodin.mapweatherforecast.data.scheduler.SchedulerProvider
import com.kborodin.mapweatherforecast.repository.WeatherRepository
import com.kborodin.mapweatherforecast.view.MainPresenter
import com.kborodin.mapweatherforecast.view.fragment.ForecastFragment
import com.kborodin.mapweatherforecast.view.fragment.WeatherFragment
import com.kborodin.mapweatherforecast.view.interfaces.Provider
import com.kborodin.mapweatherforecast.view.interfaces.View
import kotlinx.android.synthetic.main.progress_bar.*
import javax.inject.Inject

class WeatherActivity : AppCompatActivity(), View {

    @Inject
    lateinit var schedulerProvider: SchedulerProvider
    @Inject
    lateinit var weatherRepository: WeatherRepository

    private lateinit var mainPresenter: Provider
    private var tempUnit: String = "metric"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        val myApp = application as MyApp
        myApp.getMainComponent().inject(this)

        initPresenter()

        getDataFromLocation()
    }

    private fun initPresenter() {
        mainPresenter = MainPresenter(this, weatherRepository, schedulerProvider)
    }

    private fun getDataFromLocation() {
        val location = intent.extras!!.get("currentCoord") as LatLng
        mainPresenter.getDataByLocation(location.latitude.toString(), location.longitude.toString(), tempUnit)
    }

    override fun onDataByCityRetrieved(data: CombinedData) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDataByCityFailed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDataByLocationRetrieved(data: CombinedData) {
        Log.d("WeatherActivity", "data retrieved: ${data.weatherData.name}")
    }

    override fun onDataByLocationFailed() {
        Log.d("WeatherActivity", "Data by location failed")
    }


    private fun showProgressBar() {
        if (progressBar.visibility == android.view.View.GONE) {
            progressBar.visibility = android.view.View.VISIBLE
        }
    }

    private fun hideProgressBar() {
        if (progressBar.visibility == android.view.View.VISIBLE) {
            progressBar.visibility = android.view.View.GONE
        }
    }
}
