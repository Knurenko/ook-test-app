package com.example.ooktestapp.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @author Knurenko Bogdan 13.02.2024
 */
class AppEntryPoint : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppEntryPoint)
            modules(appModule)
        }
    }
}