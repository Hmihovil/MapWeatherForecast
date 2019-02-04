package com.kborodin.mapweatherforecast.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kborodin.mapweatherforecast.R
import com.kborodin.mapweatherforecast.view.activity.WeatherActivity
import com.kborodin.mapweatherforecast.view.adapter.WeatherAdapter
import kotlinx.android.synthetic.main.fragment_weather.*

class WeatherFragment : Fragment() {
    private lateinit var mWeatherAdapter: WeatherAdapter

    companion object {

        fun newInstance(): WeatherFragment {
            return WeatherFragment()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mWeatherAdapter = WeatherAdapter(activity!!.applicationContext)
        val activity = activity as WeatherActivity
        mWeatherAdapter.setDataWeather(activity.onDataReceived().weatherData)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherRecyclerView.layoutManager = LinearLayoutManager(activity)
        weatherRecyclerView.setHasFixedSize(true)
        weatherRecyclerView.adapter = mWeatherAdapter
    }

}
