package com.semyong.scalabletask

import android.app.Application
import com.semyong.scalabletask.di.apiModule
import com.semyong.scalabletask.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
//            androidLogger() // todo check for adding in a future
            androidContext(this@App)
            modules(
                listOf(
                    presentationModule,
                    apiModule
                )
            )
        }
    }
}