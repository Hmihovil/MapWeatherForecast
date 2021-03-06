package com.kborodin.mapweatherforecast.data.scheduler

import androidx.annotation.NonNull
import io.reactivex.Scheduler

interface BaseSchedulerProvider {

    @NonNull
    fun computation(): Scheduler

    @NonNull
    fun io(): Scheduler

    @NonNull
    fun mainThread(): Scheduler

    @NonNull
    fun newThread(): Scheduler
}