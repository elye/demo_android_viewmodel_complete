package com.elyeproj.simpleviewmodel

import com.elyeproj.simpleviewmodel.daggerandroid.DaggerApplicationComponent
import com.elyeproj.simpleviewmodel.daggerbasic.DaggerBasicComponent
import com.elyeproj.simpleviewmodel.koin.KoinModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import org.koin.core.context.startKoin

class MainApplication: DaggerApplication() {

    val basicComponent by lazy {
        DaggerBasicComponent.create()
    }

    override fun onCreate() {
        super.onCreate()
        startKoin { modules(KoinModule) }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().create(this)
    }
}
