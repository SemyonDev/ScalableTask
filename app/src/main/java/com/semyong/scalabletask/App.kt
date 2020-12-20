package com.semyong.scalabletask

import android.app.Application
import com.semyong.scalabletask.di.apiModule
import com.semyong.scalabletask.di.dataModule
import com.semyong.scalabletask.di.errorManagerModule
import com.semyong.scalabletask.di.presentationModule
import com.semyong.scalabletask.di.repositoryModule
import com.semyong.scalabletask.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    presentationModule,
                    apiModule,
                    dataModule,
                    errorManagerModule,
                    useCaseModule,
                    repositoryModule
                )
            )
        }
    }
}