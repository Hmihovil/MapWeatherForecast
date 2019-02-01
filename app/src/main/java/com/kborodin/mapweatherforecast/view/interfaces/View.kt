package com.kborodin.mapweatherforecast.view.interfaces

import com.kborodin.mapweatherforecast.data.model.CombinedData

interface View {

    fun onDataByCityRetrieved(data: CombinedData)

    fun onDataByCityFailed()

    fun onDataByLocationRetrieved(data: CombinedData)

    fun onDataByLocationFailed()
}