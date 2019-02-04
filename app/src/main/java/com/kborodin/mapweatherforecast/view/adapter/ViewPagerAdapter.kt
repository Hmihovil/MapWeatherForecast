package com.kborodin.mapweatherforecast.view.adapter

import android.util.SparseArray
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kborodin.mapweatherforecast.utils.Constants
import com.kborodin.mapweatherforecast.view.fragment.ForecastFragment
import com.kborodin.mapweatherforecast.view.fragment.WeatherFragment
import java.lang.ref.WeakReference

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val titles = arrayOf(Constants.TAB_CURRENT, Constants.TAB_FORECAST)

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> WeatherFragment.newInstance()
            else -> {
                ForecastFragment.newInstance()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}
