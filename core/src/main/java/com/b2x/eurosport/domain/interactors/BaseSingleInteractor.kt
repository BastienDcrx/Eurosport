package com.b2x.eurosport.domain.interactors

import io.reactivex.Scheduler
import io.reactivex.Single

abstract class BaseSingleInteractor<T, in Params> constructor(
    private val subscribeScheduler: Scheduler,
    private val observeScheduler: Scheduler
) {

    protected abstract fun provideInteractorSingle(params: Params? = null): Single<T>

    open fun execute(params: Params? = null): Single<T> {
        return this.provideInteractorSingle(params)
            .subscribeOn(subscribeScheduler)
            .observeOn(observeScheduler)
    }
}
