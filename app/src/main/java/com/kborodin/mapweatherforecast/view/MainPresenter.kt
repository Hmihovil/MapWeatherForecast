package com.kborodin.mapweatherforecast.view

import com.kborodin.mapweatherforecast.data.model.CombinedData
import com.kborodin.mapweatherforecast.data.model.ForecastData
import com.kborodin.mapweatherforecast.data.model.WeatherData
import com.kborodin.mapweatherforecast.data.scheduler.SchedulerProvider
import com.kborodin.mapweatherforecast.repository.WeatherRepository
import com.kborodin.mapweatherforecast.view.interfaces.Provider
import com.kborodin.mapweatherforecast.view.interfaces.View
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.observers.DisposableObserver

class MainPresenter(view: View, private val weatherRepository: WeatherRepository, private val schedulerProvider: SchedulerProvider)
    : RxAbstractPresenter<View>(view), Provider {

    override fun getDataByCity(cityName: String, unit: String) {
        val combined = Observable.zip(getWeatherByCity(cityName, unit), getForecastByCity(cityName, unit),
            BiFunction<WeatherData, ForecastData, CombinedData> { weather, forecast ->
                CombinedData(weather, forecast)
            })
            .compose(applySchedulers(schedulerProvider))
            .subscribeWith(object : DisposableObserver<CombinedData>() {
                override fun onComplete() {
                }

                override fun onNext(data: CombinedData) {
                    view.onDataByCityRetrieved(data)
                }

                override fun onError(e: Throwable) {
                    view.onDataByCityFailed()
                }
            })

        addDisposable(combined)
    }

    override fun getDataByLocation(lat: String, lon: String, unit: String) {
        val combined = Observable.zip(getWeatherByLocation(lat, lon, unit), getForecastByLocation(lat, lon, unit),
            BiFunction<WeatherData, ForecastData, CombinedData> { weather, forecast ->
                CombinedData(weather, forecast)
            })
            .compose(applySchedulers(schedulerProvider))
            .subscribeWith(object : DisposableObserver<CombinedData>() {
                override fun onComplete() {

                }

                override fun onNext(data: CombinedData) {
                    view.onDataByLocationRetrieved(data)
                }

                override fun onError(e: Throwable) {
                    view.onDataByLocationFailed()
                }
            })
        addDisposable(combined)
    }

    override fun unsubscribe() {
        dispose()
    }

    private fun getWeatherByCity(selectedCity: String, unit: String): Observable<WeatherData> {
        return weatherRepository.getWeatherByCity(selectedCity, unit)
    }

    private fun getForecastByCity(selectedCity: String, unit: String): Observable<ForecastData> {
        return weatherRepository.getForecastByCity(selectedCity, unit)
    }

    private fun getWeatherByLocation(lat: String, lon: String, unit: String): Observable<WeatherData> {
        return weatherRepository.getWeatherByLocation(lat, lon, unit)
    }

    private fun getForecastByLocation(lat: String, lon: String, unit: String): Observable<ForecastData> {
        return weatherRepository.getForecastByLocation(lat, lon, unit)
    }

}