package com.b2x.eurosport

import android.app.Application
import com.b2x.eurosport.presentation.di.applicationModule
import com.b2x.eurosport.presentation.di.feedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EurosportApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@EurosportApplication)
            modules(listOf(applicationModule, feedModule))
        }
    }
}
