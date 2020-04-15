package com.elyeproj.simpleviewmodel

import android.app.Application
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin { modules(KoinModule) }
    }
}