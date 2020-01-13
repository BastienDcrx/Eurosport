package com.b2x.eurosport.presentation.common

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    protected fun addToDisposables(disposable: Disposable) {
        compositeDisposable?.add(disposable)
    }

    private fun clearDisposables() {
        compositeDisposable?.clear()
    }

    override fun onCleared() {
        clearDisposables()
    }
}
