package com.elyeproj.simpleviewmodel.daggerandroid

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
object ApplicationModule {
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }
}
