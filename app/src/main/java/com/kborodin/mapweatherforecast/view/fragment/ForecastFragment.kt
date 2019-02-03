package com.kborodin.mapweatherforecast.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kborodin.mapweatherforecast.R
import com.kborodin.mapweatherforecast.data.model.ForecastData
import com.kborodin.mapweatherforecast.view.adapter.ForecastAdapter
import kotlinx.android.synthetic.main.fragment_forecast.*

class ForecastFragment: Fragment() {

    companion object {
        fun newInstance(): ForecastFragment {
            return ForecastFragment()
        }
    }

    private lateinit var mForecastAdapter: ForecastAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mForecastAdapter = ForecastAdapter(activity!!.applicationContext)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_forecast, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        forecastRecyclerView.layoutManager = LinearLayoutManager(activity)
        forecastRecyclerView.setHasFixedSize(true)
        forecastRecyclerView.adapter = mForecastAdapter
    }

    fun updateData(forecastData: ForecastData) {
        mForecastAdapter.setDataForecast(forecastData)
    }
}