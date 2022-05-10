package com.example.saryandroidchallenge.app.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.example.saryandroidchallenge.ui.main.di.mainModule

class SaryApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SaryApp)
            modules(
                listOf(
                    appModule,
                    mainModule
                )
            )
        }
    }
}