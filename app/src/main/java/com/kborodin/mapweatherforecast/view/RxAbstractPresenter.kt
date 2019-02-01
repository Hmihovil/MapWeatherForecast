package com.kborodin.mapweatherforecast.view

import com.kborodin.mapweatherforecast.data.scheduler.BaseSchedulerProvider
import io.reactivex.ObservableTransformer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class RxAbstractPresenter<V> constructor(protected val view: V) {

    private val disposables: CompositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    fun dispose() {
        disposables.clear()
    }

    fun <T> applySchedulers(schedulerProvider: BaseSchedulerProvider): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable.subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.mainThread()) }
    }
}