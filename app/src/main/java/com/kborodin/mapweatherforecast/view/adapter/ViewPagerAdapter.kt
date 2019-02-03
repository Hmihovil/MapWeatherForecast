package com.kborodin.mapweatherforecast.view.adapter

import android.util.SparseArray
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kborodin.mapweatherforecast.utils.Constants
import com.kborodin.mapweatherforecast.view.fragment.ForecastFragment
import com.kborodin.mapweatherforecast.view.fragment.WeatherFragment

class ViewPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    private val registeredFragments = SparseArray<Fragment>()
    private val titles = arrayOf(Constants.TAB_CURRENT, Constants.TAB_FORECAST)

    override fun getItem(position: Int): Fragment {
        return when(position) {
            1 -> WeatherFragment.newInstance()
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

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position) as Fragment
        registeredFragments.put(position, fragment)
        return fragment
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        registeredFragments.remove(position)
        super.destroyItem(container, position, `object`)
    }

    fun getRegisteredFragment(position: Int): Fragment {
        return registeredFragments.get(position)
    }
}